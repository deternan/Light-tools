package Calculation;

import cern.colt.matrix.DoubleMatrix1D;
import cern.colt.matrix.impl.DenseDoubleMatrix1D;

/*
 * cosine similarity
 * 
 * version: January 03, 2018 11:42 AM
 * Last revision: January 03, 2018 11:42 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * JAR
 * colt.jar
 * http://dst.lbl.gov/ACSSoftware/colt/
 */

public class SimMetrics 
{

	public SimMetrics()
	{
		DoubleMatrix1D a = new DenseDoubleMatrix1D(new double[]{1,0.5});
		DoubleMatrix1D b = new DenseDoubleMatrix1D(new double[]{0.5,1});
		double cosineDistance = a.zDotProduct(b)/Math.sqrt(a.zDotProduct(a)*b.zDotProduct(b));
		
		System.out.println(cosineDistance);
	}
	
	public static void main(String[] args)
	{
		SimMetrics sim = new SimMetrics();
	}
	
}
