package http;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import org.apache.commons.io.FileUtils;

public class Download_file
{
	private String strUrl = "http://www.twse.com.tw/exchangeReport/BFT41U?response=csv&date=20190621&selectType=ALL";
	private String theStrDestDir = "/Users/phelps/Desktop/";
	
	public Download_file() throws Exception
	{
		/*
		URL source = new URL(strUrl);
		File theStockDest = new File(theStrDestDir);
		FileUtils.forceMkdir(theStockDest);
		File destination = new File(theStrDestDir+"AA.csv");

		FileUtils.copyURLToFile(source, destination);
		System.out.println("File Downloaded Success");
		*/
		
		/*
		BufferedInputStream in = new BufferedInputStream(new URL(strUrl).openStream());
		FileOutputStream fileOutputStream = new FileOutputStream(theStrDestDir+"AA.csv");
		byte dataBuffer[] = new byte[1024];
		int bytesRead;
		while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
			fileOutputStream.write(dataBuffer, 0, bytesRead);
		}
		*/
		
		ReadableByteChannel readableChannelForHttpResponseBody = null;
        FileChannel fileChannelForDownloadedFile = null;
 
        try {
            // Define server endpoint
            URL robotsUrl = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) robotsUrl.openConnection();
            // Get a readable channel from url connection
            readableChannelForHttpResponseBody = Channels.newChannel(urlConnection.getInputStream());
            // Create the file channel to save file
            FileOutputStream fosForDownloadedFile = new FileOutputStream(theStrDestDir+"robots.csv");
            fileChannelForDownloadedFile = fosForDownloadedFile.getChannel();
            // Save the body of the HTTP response to local file
            fileChannelForDownloadedFile.transferFrom(readableChannelForHttpResponseBody, 0, Long.MAX_VALUE);
 
        } catch (IOException ioException) {
            System.out.println("IOException occurred while contacting server.");
        } finally {
 
            if (readableChannelForHttpResponseBody != null) {
 
                try {
                    readableChannelForHttpResponseBody.close();
                } catch (IOException ioe) {
                    System.out.println("Error while closing response body channel");
                }
            }
 
            if (fileChannelForDownloadedFile != null) {
 
                try {
                    fileChannelForDownloadedFile.close();
                } catch (IOException ioe) {
                    System.out.println("Error while closing file channel for downloaded file");
                }
            }
 
        }
		
	}
	
	public static void main(String args[])
	{
		try {
			Download_file df = new Download_file();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
