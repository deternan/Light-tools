package Lucene;

/*
 * Lucene Search (IndexReader)
 * based on Lucene version: 7.2 
 * 
 * version: March 11, 2019 11:20 AM
 * Last revision: March 11, 2019 11:40 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Lucene_Search_IndexReader {
	
	private String INDEX_DIR = "D:\\Eclipse\\SL4SM\\data\\Index\\";
	
	Directory dir = FSDirectory.open(Paths.get(INDEX_DIR));
    IndexReader ireader = DirectoryReader.open(dir);
    IndexSearcher isearcher = new IndexSearcher(ireader);
    StandardAnalyzer analyzer = new StandardAnalyzer();
    
	String FIELD_videoID = "videoId";
	String FIELD_TITLE = "title";
	String FIELD_CAPTION = "allText";
	String FIELD_TIME = "time";
	String FIELD_DURATION = "duration";
	
	// Query
	String queryStr = "data";
	String[] Query_fields = {FIELD_TITLE, FIELD_CAPTION};
	int Max_receive = 100;
	
	public Lucene_Search_IndexReader() throws Exception
	{
		// --------------------------------------------------------------------------  Basic (single) query		
//		Query_SingleField_search();
		// --------------------------------------------------------------------------  Basic Multiple-Field query
//		Query_MultipleField_search();
		//Fuzzy_query();
		Fuzzy_Multiquery_2(queryStr);
		
	    ireader.close();	    
	}
	
	private void Query_SingleField_search() throws Exception
	{
		QueryParser parser = new QueryParser(FIELD_TITLE, analyzer);		
		Query query = parser.parse(queryStr);				
		ScoreDoc[] SDs = isearcher.search(query, Max_receive).scoreDocs;
		
		for (int i=0; i<SDs.length; i++)
		{									
			Document hitDoc = isearcher.doc(SDs[i].doc);
			//System.out.println(hitDoc.get("video_id")+"	"+hitDoc.get("author")+"	"+hitDoc.get("timestamp")+"	"+hitDoc.get("title")+"	"+SDs[i].score);						
			System.out.println(hitDoc.get("title")+"	"+SDs[i].score);
		}
	}
	
	private void Query_MultipleField_search() throws Exception
	{
		MultiFieldQueryParser multiParser = new MultiFieldQueryParser(Query_fields, analyzer);
		Query query = multiParser.parse(queryStr);
		ScoreDoc[] SDs = isearcher.search(query, Max_receive).scoreDocs;
		
		for (int i=0; i<SDs.length; i++)
		{
			Document hitDoc = isearcher.doc(SDs[i].doc);
			System.out.println(hitDoc.get("title")+"	"+SDs[i].score);
		}
	}
	
	private void Fuzzy_Multiquery_2(String query_string) throws Exception
	{		
		// Fuzzy Query
		Query fuzzyQuery_title = new FuzzyQuery(new Term(FIELD_TITLE, query_string), 2, 0);
		Query fuzzyQuery_text = new FuzzyQuery(new Term(FIELD_CAPTION, query_string), 2, 0);
		BooleanQuery.Builder query = new BooleanQuery.Builder();
		query.add(fuzzyQuery_title, BooleanClause.Occur.SHOULD);
		query.add(fuzzyQuery_text, BooleanClause.Occur.SHOULD);
		ScoreDoc[] fSDs = isearcher.search(query.build(), Max_receive).scoreDocs;
		
		for (int i=0; i<fSDs.length; i++)
		{
			Document hitDoc = isearcher.doc(fSDs[i].doc);			
			System.out.println(hitDoc.get(FIELD_TITLE)+"	"+hitDoc.get(FIELD_CAPTION)+"	"+fSDs[i].score);
		}
	}
	
	public static void main(String[] args) 
	{
		try {
			Lucene_Search_IndexReader LS_Reader = new Lucene_Search_IndexReader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
