package Lucene;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRefBuilder;
import org.apache.lucene.util.NumericUtils;


public class Lucene_Index_count 
{
	private String indexFilePath = "";
	
	public Lucene_Index_count() throws Exception
	{
		Path path = Paths.get(indexFilePath);
		Directory index = FSDirectory.open(path);
		
		IndexReader indexReader = DirectoryReader.open(index);
		final BytesRefBuilder bytes = new BytesRefBuilder(); 
		NumericUtils.longToPrefixCoded(Long.valueOf("alias").longValue(),0,bytes);
		//NumericUtils.longToPrefixCoded(Long.valueOf(longTerm).longValue(),0,bytes);
		
		TermsEnum termEnum = MultiFields.getTerms(indexReader, "field").iterator(null);
		termEnum.seekExact(bytes.toBytesRef());
		int count = termEnum.docFreq(); 
		
		System.out.println(count);
	}
	
	public static void main(String[] args)
	{
		try {
			Lucene_Index_count LIC = new Lucene_Index_count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
