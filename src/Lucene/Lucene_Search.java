package Lucene;

/*
 * Lucene Search
 * 
 * version: January 24 20, 2018 04:03 PM
 * Last revision: January 25 20, 2018 10:35 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * https://www.javacodegeeks.com/2015/09/advanced-lucene-query-examples.html
 * 
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.dic.Hit;


public class Lucene_Search 
{
	private String indexFilePath = "";
	String FIELD_CONTENTS = "";
	String queryStr = "";
	
	int Max_receive = 100;
	
	public Lucene_Search() throws Exception
	{		
		Path path = Paths.get(indexFilePath);
				
		StandardAnalyzer analyzer = new StandardAnalyzer();		

		// To store an index on disk, use this instead:	    
		Directory index = FSDirectory.open(path);
		
		DirectoryReader ireader = DirectoryReader.open(index);
		IndexSearcher isearcher = new IndexSearcher(ireader);
		
		// Parse a simple query that searches for "TEXT":		
		QueryParser parser = new QueryParser(FIELD_CONTENTS, analyzer);
		parser.setDefaultOperator(QueryParser.OR_OPERATOR);
		Query query = parser.parse(queryStr);
				
		ScoreDoc[] SDs = isearcher.search(query, Max_receive).scoreDocs;
		
		System.out.println(SDs.length);
		
		for (int i=0; i<SDs.length; i++)
		{									
			Document hitDoc = isearcher.doc(SDs[i].doc);
			System.out.println(hitDoc.get("video_id")+"	"+SDs[i].score);			
			
		}
	
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
