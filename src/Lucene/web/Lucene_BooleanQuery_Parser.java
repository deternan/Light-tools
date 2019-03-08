//package Update.Search;

/*
 * Apache Lucene Query(Boolean) (Lucene version 5.1.0)
 * 
 * version: January 11, 2013	03:27 PM
 * Last revision: May 22, 2015	06:40 PM
 * 
 * Author: Chao-Hsuan Ke
 */

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Lucene_BooleanQuery_Parser extends Parameters
{		
	
	public Lucene_BooleanQuery_Parser(String query_string) throws IOException, ParseException
	{		
		Path path = Paths.get(lucene_index);		
//		StandardAnalyzer analyzer = new StandardAnalyzer();		
		Analyzer analyzer = new StandardAnalyzer();
		
		// To store an index on disk, use this instead:	    
		Directory index = FSDirectory.open(path);		
		DirectoryReader ireader = DirectoryReader.open(index);
		IndexSearcher isearcher = new IndexSearcher(ireader);
					
		QueryParser parser = new QueryParser(allText_field, analyzer);
		//parser.setDefaultOperator(QueryParser.OR_OPERATOR);
		Query query = parser.parse(query_string);
				
		ScoreDoc[] SDs = isearcher.search(query, Max_receive).scoreDocs;
			
		for (int i=0; i<SDs.length; i++)
		{									
			Document hitDoc = isearcher.doc(SDs[i].doc);
			//System.out.println(hitDoc.get("itemId"));
			System.out.println(i+"	"+hitDoc.get(type_Tag)+"	"+hitDoc.get(itemId_Tag)+"	"+hitDoc.get(title_Tag)+"	"+SDs[i].score);						
		}
	
		ireader.close();
		index.close();
	}
	
	public static void main(String args[])
	{		
		//String query_string = "Security";
		String query_string = args[0];
		
		try {
			Lucene_BooleanQuery_Parser LQ = new Lucene_BooleanQuery_Parser(query_string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

