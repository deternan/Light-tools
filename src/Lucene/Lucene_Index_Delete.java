package Update.Search.Data;

/*
 *  Lucene Index (Delete)
 * 
 *	Version: April 02, 2019 09:09 AM
 * 	Last revision: April 02, 2019 09:09 AM
 * 	
 */

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Lucene_Index_Delete  extends Parameters {

	String deleteId = "5566";
	
	// Lucene Index	
	IndexWriter indexWriter;
	Analyzer analyzer = new StandardAnalyzer();
	private static Directory dir = null;
	
	public Lucene_Index_Delete()
	{
		// Lucene
		File f = new File(lucene_index);
		try {
			dir = FSDirectory.open(f.toPath());
			indexWriter = new IndexWriter(dir, new IndexWriterConfig(analyzer));
			Term term = new Term(itemId_Tag, deleteId);
            indexWriter.deleteDocuments(term);
            indexWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args)
	{
		Lucene_Index_Delete DLI = new Lucene_Index_Delete();
	}
	
}
