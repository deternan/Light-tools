package Text_related.Stanford;

/*
 * JAR
 * stanford-postagger-3.9.1.jar
 * 
 */

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.util.CoreMap;


public class English_SegDemo {

	static String text = "Three of the top 10 busiest airports in the world are in Greater China, where aviation is taking off dramatically. The country is building eight new airports per year, and aims to open 216 by 2035.\r\n" + 
			"But though Asia is the most crowded region in the world for air travel, for the most part it provides a masterclass in airports. Four of the top five airports named at the recent Skytrax World Airports Awards are in the region.";
	
	public English_SegDemo() throws Exception
	{		
		
//		tokenization();
        
//		Segmenter();
		
//		Test();
		
		parsing();
	}
	
	private void tokenization() {
		//English tokenization
//        PTBTokenizer<CoreLabel> ptbTokenizer = new PTBTokenizer<CoreLabel>(new StringReader("i love machine learning and i'm stupid"),
//                new CoreLabelTokenFactory(), "");
//        while(ptbTokenizer.hasNext()) {
//            CoreLabel word = ptbTokenizer.next();
//            System.out.println(word);
//        }
	}
	
	private void Segmenter() {
		
		StanfordCoreNLP nlp = new StanfordCoreNLP("StanfordCoreNLP.properties");
		//StanfordCoreNLP nlp = new StanfordCoreNLP("D:\\Eclipse\\Common_Package\\StanfordCoreNLP-chinese.properties");
		
		//Properties props = new Properties();
		//props.setProperty("annotators", "tokenize, ssplit, pos, parse");
		//props.setProperty("annotators", "tokenize, parse");
		//props.setProperty("tokenize.language", "en");
		
		
		//StanfordCoreNLP nlp = new StanfordCoreNLP(props);		
        Annotation document = nlp.process(text);
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        for(CoreMap sentence : sentences) {
            for(CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                System.out.println(word);
            }
        }
		
	}
	
	private void Test() throws Exception {
		
		String taggerPath = "taggers/english-left3words-distsim.tagger";		
		MaxentTagger tagger = new MaxentTagger(taggerPath);

		String tag = tagger.tagString(text);
        String[] eachTag = tag.split("\\s+");
        System.out.println("Word      " + "Standford tag");
        System.out.println("----------------------------------");
        for(int i = 0; i< eachTag.length; i++) {
            System.out.println(eachTag[i].split("_")[0] +"           "+ eachTag[i].split("_")[1]);
        }
	}
	
	public static void parsing() {
			
		String taggerPath = "taggers/english-left3words-distsim.tagger";		
		MaxentTagger tagger = new MaxentTagger(taggerPath);
		
		DocumentPreprocessor tokenizer = new DocumentPreprocessor (new StringReader(text)); 
		for (List<HasWord> sentence : tokenizer) {

			System.out.println(sentence);
			List<TaggedWord> tagged = tagger.tagSentence(sentence);
	        System.out.println("Tagging: " + tagged);
		}	
	}
	
	public static void main(String[] args) {
		
		try {
			English_SegDemo seg = new English_SegDemo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
