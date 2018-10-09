package Lucene;

/*
 * Lucene Search
 * based on Lucene version: 7.2 
 * 
 * version: January 24 20, 2018 04:03 PM
 * Last revision: October 09, 2018 03:55 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * https://www.javacodegeeks.com/2015/09/advanced-lucene-query-examples.html
 * 
 * Boolean Query
 * http://tw.gitbook.net/lucene/lucene_booleanquery.html
 * 
 * 
 */

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoublePoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

public class Lucene_Search 
{	
	private String indexFilePath = "";
	Path path = Paths.get(indexFilePath);				
	StandardAnalyzer analyzer = new StandardAnalyzer();		
	// To store an index on disk, use this instead:	    
	Directory index = FSDirectory.open(path);		
	DirectoryReader ireader = DirectoryReader.open(index);
	IndexSearcher isearcher = new IndexSearcher(ireader);
	
	String FIELD_videoID = "videoId";
	String FIELD_TITLE = "title";
	String FIELD_CAPTION = "allText";
	String FIELD_TIME = "time";
	String FIELD_DURATION = "duration";
	// Range
	int start_point = 0;
	int end_point = 300;

	
	// Query
	String queryStr = "data";
	String[] Query_fields = {FIELD_TITLE, FIELD_CAPTION};
	String queryvideoId = "59717f1a2d6dc34a9cf7bda9";
	
	int Max_receive = 100;
	
	public Lucene_Search() throws Exception
	{		
		// --------------------------------------------------------------------------  Basic (single) query			
		//Query_SingleField_search();
		// --------------------------------------------------------------------------  Basic Multiple-Field query
		Query_MultipleField_search();
		// --------------------------------------------------------------------------  Testing (multiple query)
		//Multi_query();
		
		// --------------------------------------------------------------------------  Testing (time)
		//timestamp_query();
		
		// --------------------------------------------------------------------------  Range query 		
		//Range();		
		
		// --------------------------------------------------------------------------  Fuzzy query
		//Fuzzy_query();
		
		
		// --------------------------------------------------------------------------
	    
		ireader.close();
		index.close();
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
	
	private void Multi_query() throws Exception
	{
		QueryParser queryParser = new QueryParser(FIELD_TITLE, analyzer);
		//queryParser.setAllowLeadingWildcard(true);
		queryParser.setDefaultOperator(QueryParser.Operator.AND);
		
		BooleanQuery.Builder querybuilder = new BooleanQuery.Builder();
		//query.add(new TermQuery(new Term("type", type)), Occur.MUST);
		querybuilder.add(queryParser.parse(queryStr), Occur.MUST);
		
		TopDocs topDocs = isearcher.search(querybuilder.build(), Max_receive);
		for(int i=0;i<topDocs.scoreDocs.length;i++)
		{
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			int no = scoreDoc.doc;
			Document document = isearcher.doc(no);
			System.out.println(document.get(""));
		}
		
	}
	
	private void Range() throws Exception
	{				
		Query doublequery = DoublePoint.newRangeQuery(FIELD_DURATION, start_point, end_point);
		ScoreDoc[] SDs = isearcher.search(doublequery, Max_receive).scoreDocs;
		
		for (int i=0; i<SDs.length; i++)
		{									
			Document hitDoc = isearcher.doc(SDs[i].doc);
			System.out.println(hitDoc.get(""));						
		}
	}
	
	private void timestamp_query() throws Exception
	{
		QueryParser queryParser = new QueryParser(FIELD_TITLE, analyzer);
		queryParser.setAllowLeadingWildcard(true);
		queryParser.setDefaultOperator(QueryParser.Operator.AND);
		
		BooleanQuery.Builder querybuilder = new BooleanQuery.Builder();	
		querybuilder.add(queryParser.parse(queryStr), Occur.MUST);
		
		Query item_query = new TermRangeQuery(FIELD_TIME, new BytesRef("20170601090900000"), new BytesRef("20170610055319000"), true, true);
		querybuilder.add(item_query, Occur.MUST);
		
		TopDocs topDocs = isearcher.search(querybuilder.build(), Max_receive);
		for(int i=0;i<topDocs.scoreDocs.length;i++)
		{
			
		}
	}
	
	private void Fuzzy_query() throws Exception
	{
		// 
		int fuzziness = 2;
		Query fuzzyquery = new FuzzyQuery(new Term(FIELD_TITLE, queryStr), fuzziness);
		ScoreDoc[] F_SDs = isearcher.search(fuzzyquery, Max_receive).scoreDocs;
		
		for (int i=0; i<F_SDs.length; i++)
		{
			
		}
	}
	
	private void Fuzzy_Multiquery() throws Exception
	{
		int fuzziness = 2;
		Query fuzzyquery = new FuzzyQuery(new Term(FIELD_TITLE, queryStr), fuzziness);	
		//ScoreDoc[] SDs = isearcher.search(fuzzyquery, Max_receive).scoreDocs;
		
		// --------------------------------------------------------------------------  combination Fuzzy search (multi-query)				
		BooleanQuery.Builder querybuilder = new BooleanQuery.Builder();
		QueryParser queryParser = new QueryParser(FIELD_videoID, analyzer);
		querybuilder.add(queryParser.parse(queryvideoId), Occur.MUST);
		querybuilder.add(fuzzyquery, Occur.MUST);		
			
		TopDocs hits = isearcher.search(querybuilder.build(), Max_receive);
		
		
		for(int i=0;i<hits.scoreDocs.length;i++)
		{
			ScoreDoc scoreDoc = hits.scoreDocs[i];
			int no = scoreDoc.doc;
			Document document = isearcher.doc(no);
			
			System.out.println(document.get(""));
		}
	}
	
	public static void main(String[] args) 
	{
		try {
			Lucene_Search search = new Lucene_Search();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
