/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

/*
 * 
 */
/*
 * 
 */

package com.google.api.services.samples.youtube.cmdline.data;

/*
 * https://developers.google.com/youtube/registering_an_application
 * https://developers.google.com/api-client-library/dotnet/guide/aaa_client_secrets
 * http://stackoverflow.com/questions/22781932/youtube-api-v3-java
 * 
 * Caption
 * http://stackoverflow.com/questions/23665343/get-closed-caption-cc-for-youtube-video
 * 
 */

import Caption.Subtitle_output;
import Caption.YouTube_caption_check_retrieval;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.samples.youtube.cmdline.Auth;
import com.google.api.services.samples.youtube.cmdline.data.Captions.Action;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTube.Captions.Download;
import com.google.api.services.youtube.YouTube.Videos;
import com.google.api.services.youtube.model.Caption;
import com.google.api.services.youtube.model.CaptionListResponse;
import com.google.api.services.youtube.model.CaptionSnippet;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Print a list of videos matching a search term.
 *
 * @author Jeremy Walker
 */
public class Search
{
    /**
     * Define a global variable that identifies the name of a file that
     * contains the developer's API key.
     */
    private static final String PROPERTIES_FILENAME = "youtube.properties";
    private static final long NUMBER_OF_VIDEOS_RETURNED = 50;

    /**
     * Define a global instance of a Youtube object, which will be used
     * to make YouTube Data API requests.
     */
    private static YouTube youtube;

    /**
     * Initialize a YouTube object to search for videos on YouTube. Then
     * display the name and thumbnail image of each video in the result set.
     *
     * @param args command line args.
     */
    
//    private static String query_input = "ted taipei";

    
    // Caption
    static YouTube_caption_check_retrieval you_caption;
    // Subtitle output
    static Subtitle_output stitle_output;    
    // folder
    private static String folder;
    
    public Search(String query_input)
    {
    	folder = query_input;
    	
    	// Read the developer key from the properties file.
        Properties properties = new Properties();
        try {
            InputStream in = Search.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
            properties.load(in);

        } catch (IOException e) {
            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
                    + " : " + e.getMessage());
            System.exit(1);
        }

        try {
            // This object is used to make YouTube Data API requests. The last
            // argument is required, but since we don't need anything
            // initialized when the HttpRequest is initialized, we override
            // the interface and provide a no-op function.
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-cmdline-search-sample").build();

            // Prompt the user to enter a query term.
            //String queryTerm = getInputQuery(query_input);
            String queryTerm = query_input;

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key from the {{ Google Cloud Console }} for
            // non-authenticated requests. See:
            // {{ https://cloud.google.com/console }}
            String apiKey = properties.getProperty("youtube.apikey");
            search.setKey(apiKey);
            search.setQ(queryTerm);
            
            // Restrict the search results to only include videos. See:
            // https://developers.google.com/youtube/v3/docs/search/list#type
            search.setType("video");

            // To increase efficiency, only retrieve the fields that the
            // application uses.
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
//            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
            
            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            if (searchResultList != null) {
                prettyPrint(searchResultList.iterator(), queryTerm);
            }
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /*
     * Prints out all results in the Iterator. For each result, print the
     * title, video ID, and thumbnail.
     *
     * @param iteratorSearchResults Iterator of SearchResults to print
     *
     * @param query Search query (String)
     */
    
    private static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) throws Exception 
    {

//        System.out.println("\n=============================================================");
//        System.out.println("   First " + NUMBER_OF_VIDEOS_RETURNED + " videos for search on \"" + query + "\".");
//        System.out.println("=============================================================\n");

        if (!iteratorSearchResults.hasNext()) {
            System.out.println(" There aren't any results for your query.");
        }
        
        SearchResult singleVideo;
        ResourceId rId;
        while (iteratorSearchResults.hasNext()) 
        {
            singleVideo = iteratorSearchResults.next();
            rId = singleVideo.getId();            
            
            // Confirm that the result represents a video. Otherwise, the
            // item will not contain a video ID.
            
            if (rId.getKind().equals("youtube#video")) 
            {
            	System.out.println(" Video Id: " + rId.getVideoId());
            	
//                Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();
//					
//                System.out.println(" Video Id: " + rId.getVideoId());
////                System.out.println(" PlaylistVideo Id: " + rId.getPlaylistId());
//                System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
////                System.out.println(" Thumbnail: " + thumbnail.getUrl());
////                System.out.println(" Description: " + singleVideo.getSnippet().getDescription());
//                System.out.println(" Date: " + singleVideo.getSnippet().getPublishedAt());
//                //System.out.println(" Other: " + singleVideo.getSnippet());
//                
//                // Captions
//                you_caption = new YouTube_caption_check_retrieval(rId.getVideoId(), "zh-TW");
//                System.out.println(" Subtitle: " + you_caption.Return_subtitle());
//                // Subtitle output
//                if(you_caption.Return_subtitle()!= null){
//                	stitle_output = new Subtitle_output(rId.getVideoId(), folder, you_caption.Return_subtitle());
//                }                                
//                System.out.println("\n-------------------------------------------------------------\n");
            }
        }
    }
    
//    public static void main(String[] args) 
//    {
//    	Search search = new Search("ted taipei");
//    }
    
}
