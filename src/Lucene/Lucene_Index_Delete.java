package Lucene;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


public class Lucene_Index_Delete 
{
	private String indexFilePath = "";
	
	public Lucene_Index_Delete()
	{
		try{		   
			
			Path path = Paths.get(indexFilePath);
			Directory index = FSDirectory.open(path);
			StandardAnalyzer analyzer = new StandardAnalyzer();
						
			Document doc = new Document();
			doc.add(new TextField("alias", "SCORM.pdf", Field.Store.YES));
			doc.add(new TextField("filename", "03684a50ddb5a8e735d4fb17a1599ed3.pdf", Field.Store.YES));
			doc.add(new TextField("resource_path", "/media/03684a50ddb5a8e735d4fb17a1599ed3.pdf", Field.Store.YES));
			
			//IndexWriter writer = new IndexWriter(index, analyzer, true, IndexWriter.MaxFieldLength.LIMITED);
			
			
		    System.out.println("Delete Finished");
		    
		  }
		  catch(Exception x){x.printStackTrace();
		  }
	}
	
	public static void main(String[] args)
	{
		Lucene_Index_Delete LID = new Lucene_Index_Delete();
	}
}
