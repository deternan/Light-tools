package Stanford;

/*
 * Chinese character Segmentation 
 * 
 * version: August 22, 2019 09:56 AM
 * Last revision: April 24, 2019 04:09 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */


import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;


/** This is a very simple demo of calling the Chinese Word Segmenter
 *  programmatically.  It assumes an input file in UTF8.
 *  <p/>
 *  <code>
 *  Usage: java -mx1g -cp seg.jar SegDemo fileName
 *  </code>
 *  This will run correctly in the distribution home directory.  To
 *  run in general, the properties for where to find dictionaries or
 *  normalizations have to be set.
 *
 *  @author Christopher Manning
 */

public class Chinese_Seg {

//  private static final String basedir = System.getProperty("SegDemo", "data");
	private static final String basedir = "/Users/phelps/Documents/github/Light-tools/data/stanford-word-segmenter/";	// data path
	
	static List<String> segmented;
	CRFClassifier<CoreLabel> segmenter;
	
	// Segmented Terms
	Vector segTrems = new Vector();
	
	public Chinese_Seg() throws Exception
	{
		System.setOut(new PrintStream(System.out, true, "utf-8"));

	    Properties props = new Properties();
	    props.setProperty("sighanCorporaDict", basedir);
	    // props.setProperty("NormalizationTable", "data/norm.simp.utf8");
	    // props.setProperty("normTableEncoding", "UTF-8");
	    
	    props.setProperty("serDictionary", basedir + "dict-chris6.ser.gz");
//	    if (args.length > 0) {
//	      props.setProperty("testFile", args[0]);
//	    }
	    props.setProperty("inputEncoding", "UTF-8");
	    props.setProperty("sighanPostProcessing", "true");

	    segmenter = new CRFClassifier<>(props);
	    segmenter.loadClassifierNoExceptions(basedir + "ctb.gz", props);
//	    for (String filename : args) {
//	      segmenter.classifyAndWriteAnswers(filename);
//	    }
	    
	    String sample = "我住在美国。";
	    segmented = segmenter.segmentString(sample);
	    System.out.println(segmented);
	    
	    Terms_Split(segmented);
	    
	    sample = "超人氣珍珠泡芙怎麼咬都爆漿！IG南北兩大夯店推薦";
	    segmented = segmenter.segmentString(sample);
	    System.out.println(segmented);
	    
	    Terms_Split(segmented);
	    
	    sample = "房子，在中国具有不一般的意义";
	    segmented = segmenter.segmentString(sample);
	    System.out.println(segmented);
	    
	    Terms_Split(segmented);
	    
	    System.out.println(segTrems.size());
	    for(int i=0; i<segTrems.size(); i++) {
	    	System.out.println(segTrems.get(i));
	    }
	    
	}
	
	private void Terms_Split(List<String> listStr)
	{
		for(int i=0; i<listStr.size(); i++) {
			
			// Filter (length>1)
			if(listStr.get(i).toString().trim().length() > 1) {
				segTrems.add(listStr.get(i));
			}			
		}		
	}
	
	
  public static void main(String[] args) throws Exception {
	  
	  Chinese_Seg seg = new Chinese_Seg();

    
    
  }
  
  

}

