/*
 * TF-IDF
 * 
 * version: March 20, 2017 09:51 AM
 * Last revision: March 20, 2017 09:51 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CosineSimilarity 
{
	private List tfidfDocsVector = new ArrayList<>();
	private double cosine_sim_value;
	
	private double[] vector_list_1;	
	private double[] vector_list_2;
	
	public double cosineSimilarity_vale;
	public Vector cosineSimilarity_vale_vec;
	
	public CosineSimilarity(double[] targetVector, List tfidfDocsVector)
	{
		
		cosineSimilarity_vale_vec = new Vector();
							
		vector_list_1 = targetVector;
			
		for (int j = 0; j < tfidfDocsVector.size(); j++) 
        {			
			vector_list_2 = (double[]) tfidfDocsVector.get(j);            	
			cosineSimilarity_vale = CosineSimilarity(vector_list_1, vector_list_2);
			cosineSimilarity_vale_vec.add(cosineSimilarity_vale);			
        }        
    }    
	
	private double CosineSimilarity(double[] docVector1, double[] docVector2)
	{
		double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double cosineSimilarity = 0.0;
        
        for (int i = 0; i < docVector1.length; i++)
        {
            dotProduct += docVector1[i] * docVector2[i];
            magnitude1 += Math.pow(docVector1[i], 2);
            magnitude2 += Math.pow(docVector2[i], 2);
        }

        magnitude1 = Math.sqrt(magnitude1);
        magnitude2 = Math.sqrt(magnitude2);

        if (magnitude1 != 0.0 | magnitude2 != 0.0) {
            cosineSimilarity = dotProduct / (magnitude1 * magnitude2);
        } else {
            return 0.0;
        }
        return cosineSimilarity;
	}

	public Vector Return_cosineSimilarity_vale_vec()
	{
		return cosineSimilarity_vale_vec;
	}
	
}
