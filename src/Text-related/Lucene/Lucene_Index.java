package Text_related.Lucene;

/*
 *  Chinese Words check
 * 
 *	Version: January 15, 2018 02:14 PM
 * 	Last revision: January 15, 2018 02:14 PM
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

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class Lucene_Index 
{
	// IKAnalyzer
	Analyzer analyzer = new IKAnalyzer(true);
	
	private static Directory dir = null;
	private static IndexReader reader = null;
	String text;
	
	// Lucene Index
	private String index_folder = "C:\\ii\\";
	private String str = "蘋果（Apple）承諾年初 iOS 系統更新可查看 iPhone 電池狀況，料將再掀電池更換潮，國外網站以美國蘋果零售人力推估，得 2.7 年消化預約客戶，大幅超出原訂年底截止時間。 蘋果變更 iOS 軟體導致舊款 iPhone 降速以延長電池壽命的做法引起爭議，蘋果日前為此道歉，並宣布針對需要更換電池的 iPhone 6 及其之後推出的機種，已過保固的電池替換費用從 79 美元降價到 29 美元，降幅 50 美元，從 2018 年 1 月開始至 12 月在全球適用。";
	private String index_field = "";
	
	private String source_path = "C:\\a.txt";
	
	public Lucene_Index() throws Exception 
	{
		Readfile();						
		index();
	}

	private void Readfile() throws Exception, FileNotFoundException
	{
		InputStreamReader isReader = new InputStreamReader(new FileInputStream(source_path));
		BufferedReader br = new BufferedReader(isReader);
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = br.readLine()) != null) 
		{
			sb.append(s);
		}
		isReader.close();
		br.close();
		
		text = sb.toString();
		//System.out.println(text1);
	}
	
	private void index()
	{
		IndexWriter indexWriter = null;
		try {			
			indexWriter = new IndexWriter(dir, new IndexWriterConfig(analyzer));
			
			// doc1
			Document doc1 = new Document();
			doc1.add(new TextField("title", "001", Field.Store.YES));
			doc1.add(new TextField("summary", text, Field.Store.YES));			
			
			indexWriter.addDocument(doc1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (indexWriter != null) {
				try {
					indexWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) 
	{		
		try {
			Lucene_Index ss = new Lucene_Index();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
