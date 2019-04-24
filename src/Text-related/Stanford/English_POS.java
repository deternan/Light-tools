package Text_related.Stanford;

/*
 * Part of Speech 
 * 
 * version: August 24, 2019 09:56 AM
 * Last revision: April 24, 2019 01:19 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * JAR
 * stanford-corenlp-3.4.jar
 * stanford-corenlp-3.4-models.jar
 */

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class English_POS {

	public English_POS()	
	{
		// Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
 
        // The sample string
        String sample = "This is a sample text";
 
        // The tagged string
        String tagged = tagger.tagString(sample);
 
        // Output the result
        System.out.println(tagged);
	}
	
	public static void main(String[] args)
	{
		English_POS pos = new English_POS();
	}
}
