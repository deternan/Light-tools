package Lucene;

/*
 * Lucene Search
 * based on Lucene version: 7.0 
 * 
 * version: January 24 20, 2018 04:03 PM
 * Last revision: February 23, 2018 06:54 PM
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
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;


public class Lucene_Search 
{
	private String indexFilePath = "D:\\Eclipse\\Lucene\\Index\\eTube_Content\\";
	String FIELD_CONTENTS = "title";
	String FIELD_TIME = "time";
	String queryStr = "中型PLC";
	
	int Max_receive = 100;
	
	public Lucene_Search() throws Exception
	{		
		Path path = Paths.get(indexFilePath);
				
		StandardAnalyzer analyzer = new StandardAnalyzer();		
		// To store an index on disk, use this instead:	    
		Directory index = FSDirectory.open(path);		
		DirectoryReader ireader = DirectoryReader.open(index);
		IndexSearcher isearcher = new IndexSearcher(ireader);
		
		// --------------------------------------------------------------------------  Testing (multiple query)
		QueryParser queryParser = new QueryParser(FIELD_CONTENTS, analyzer);
		queryParser.setAllowLeadingWildcard(true);
		queryParser.setDefaultOperator(QueryParser.Operator.AND);
		
		
		BooleanQuery.Builder querybuilder = new BooleanQuery.Builder();
		//query.add(new TermQuery(new Term("type", type)), Occur.MUST);
		querybuilder.add(queryParser.parse(queryStr), Occur.MUST);
		
		Query item_query = new TermRangeQuery(FIELD_TIME, new BytesRef("20170601090900000"), new BytesRef("20170610055319000"), true, true);
		querybuilder.add(item_query, Occur.MUST);
		
		
		//ScoreDoc[] SDs = isearcher.search(querybuilder.build(), Max_receive).scoreDocs;
		//System.out.println(SDs.length);
		
		// --------------------------------------------------------------------------  Basic (single) query			
		QueryParser parser = new QueryParser(FIELD_CONTENTS, analyzer);
		//parser.setDefaultOperator(QueryParser.OR_OPERATOR);
		Query query = parser.parse(queryStr);				
		ScoreDoc[] SDs = isearcher.search(query, Max_receive).scoreDocs;
		
		//System.out.println(SDs.length);
		
		for (int i=0; i<SDs.length; i++)
		{									
			Document hitDoc = isearcher.doc(SDs[i].doc);
			System.out.println(hitDoc.get("video_id")+"	"+hitDoc.get("author")+"	"+hitDoc.get("timestamp")+"	"+hitDoc.get("title")+"	"+SDs[i].score);						
		}
		// --------------------------------------------------------------------------
	    
		ireader.close();
		index.close();
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
