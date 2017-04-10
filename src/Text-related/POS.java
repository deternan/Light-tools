

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class POS 
{
	String input_sentence = "There are various ways to call the code, but here's a simple example to get started with using either PTBTokenizer directly or calling DocumentPreprocessor.";
	
	public POS() throws Exception
	{		
        MaxentTagger tagger = new MaxentTagger("C:\\stanford-postagger-2016-10-31\\models\\english-left3words-distsim.tagger");
        String tagged = tagger.tagString(input_sentence);        
        System.out.println(tagged);
	}
	
	public static void main(String[] args)
	{
		
		try {
			POS token = new POS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
