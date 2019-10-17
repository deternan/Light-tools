package Mathematic;

/*
 * version: August 01, 2019 06:23 PM
 * Last revision: August 01, 2019 06:23 PM
 * 
 * Author : Chao-Hsuan Ke
 * E-mail : phelpske.dev at gmail dot com
 * 
 */

public class cosineSimilarity {

	public cosineSimilarity()
	{
		double value;
		
		double[] vectorA = {1.22, 1.5};
		double[] vectorB = {1.1, 1.49};
		
		double dotProduct = 0.0;
	    double normA = 0.0;
	    double normB = 0.0;
	    for (int i = 0; i < vectorA.length; i++) {
	        dotProduct += vectorA[i] * vectorB[i];
	        normA += Math.pow(vectorA[i], 2);
	        normB += Math.pow(vectorB[i], 2);
	    }   
	    
	    value =  dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
	    System.out.println(value);
	}
	
	public static void main(String[] args)
	{
		cosineSimilarity cs = new cosineSimilarity();
	}
	
}
