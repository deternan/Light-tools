package Text_related.Lucene;

/*
 *  Chinese Words check
 * 
 *	Version: January 15, 2018 02:14 PM
 * 	Last revision: January 15, 2018 02:40 PM
 * 
 */

/*
 * JAR
 * lucene-core-7.2.0.jar
 * lucene-queries-7.2.0.jar
 * lucene-queryparser-7.2.0.jar
 * lucene-analyzers-common-7.2.0.jar
 * ik-analyzer-solr5-5.x.jar
 */

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class Lucene_Search 
{
	// IKAnalyzer
	Analyzer analyzer = new IKAnalyzer(true);
	
	private static Directory dir = null;
	private static IndexReader reader = null;
	String text1;
	
	// Lucene Index
	private String index_folder = "C:\\ii\\";
	private String search_query = "";
	private String search_field = "";
	
	public Lucene_Search() throws Exception 
	{
		search(search_query);		
	}
	
	public void search(String query) throws Exception 
	{
		
		Directory dir = FSDirectory.open(Paths.get(index_folder));
	    IndexReader reader = DirectoryReader.open(dir);
	    IndexSearcher searcher = new IndexSearcher(reader);
		
        
	    QueryParser qp = new QueryParser(search_field, new StandardAnalyzer());
	    Query idQuery = qp.parse(query);
	    TopDocs hits = searcher.search(idQuery, 10);
	    
	    System.out.println(hits.totalHits);
	    
	    for (ScoreDoc sd : hits.scoreDocs)
        {
            Document d = searcher.doc(sd.doc);
            System.out.println(String.format(d.get(search_field)));
        }
	}

	public static void main(String[] args) 
	{
		//new Searcher().check();
		try {
			Lucene_Search ss = new Lucene_Search();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
