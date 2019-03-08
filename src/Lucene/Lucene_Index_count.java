package Lucene;

/*
 * Lucene Index
 * version: August 27, 2018 07:15 PM
 * Last revision: March 08, 2019 06:31 PM	
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Lucene_Index_count 
{
	private String indexFilePath = "D:\\Eclipse\\SL4SM\\data\\Index\\";
	
	public Lucene_Index_count() throws Exception
	{
		Path path = Paths.get(indexFilePath);
		Directory index = FSDirectory.open(path);
		
		IndexReader indexReader = DirectoryReader.open(index);

		
		
		System.out.println("No. of indexed	doc.	" + indexReader.numDocs());
		System.out.println("No. of indexed	" + indexReader.maxDoc());
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
