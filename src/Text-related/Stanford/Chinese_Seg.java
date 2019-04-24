package Text_related.Stanford;

/*
 * Auto-Updated auto-completed Items 
 * 
 * version: August 22, 2019 09:56 AM
 * Last revision: April 23, 2019 10:21 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */


import java.io.*;
import java.util.List;
import java.util.Properties;

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
	private static final String basedir = "C:\\Users\\barry.ke\\Desktop\\stanford-segmenter-2018-10-16\\data\\";
	
	static List<String> segmented;
	
  public static void main(String[] args) throws Exception {
	  
    System.setOut(new PrintStream(System.out, true, "utf-8"));

    Properties props = new Properties();
    props.setProperty("sighanCorporaDict", basedir);
    // props.setProperty("NormalizationTable", "data/norm.simp.utf8");
    // props.setProperty("normTableEncoding", "UTF-8");
    
    props.setProperty("serDictionary", basedir + "/dict-chris6.ser.gz");
    if (args.length > 0) {
      props.setProperty("testFile", args[0]);
    }
    props.setProperty("inputEncoding", "UTF-8");
    props.setProperty("sighanPostProcessing", "true");

    CRFClassifier<CoreLabel> segmenter = new CRFClassifier<>(props);
    segmenter.loadClassifierNoExceptions(basedir + "/ctb.gz", props);
    for (String filename : args) {
      segmenter.classifyAndWriteAnswers(filename);
    }

    String sample = "我住在美国。";
    segmented = segmenter.segmentString(sample);
    System.out.println(segmented);
    //segmented.clear();
    
    sample = "超人氣珍珠泡芙怎麼咬都爆漿！IG南北兩大夯店推薦";
    segmented = segmenter.segmentString(sample);
    System.out.println(segmented);
    
    sample = "房子，在中国具有不一般的意义";
    segmented = segmenter.segmentString(sample);
    System.out.println(segmented);
    
  }

}

