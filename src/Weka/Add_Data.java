package Weka;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.filters.unsupervised.attribute.Add;

/*
 * Generated arff dataset
 * 
 * version: December 12, 2017 05:37 PM
 * Last revision: December 13, 2017 10:34 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * JAR
 * weka-dev-3.7.6.jar
 * 
 */

public class Add_Data 
{
	// Parameters
	private final int dim = 10;	
	double[] instnace_num = new double[dim];
	
	// Attritual
	FastVector<Attribute> attrs = new FastVector();
	// Class
	
	public Add_Data()
	{
		Attributes();		
		Class();
		Instances();
	}
	
	private void Attributes()
	{
		Attribute att;
		
		for(int i=0; i<dim; i++)
		{
			att = new Attribute(String.valueOf(i), i);
			attrs.addElement(att);
			System.out.println(attrs.get(i));
		}        
	}
	
	private void Class()
	{
		// Create vector to hold nominal values "first", "second", "third" 
		FastVector my_nominal_values = new FastVector(3);
		my_nominal_values.addElement("first");
		my_nominal_values.addElement("second");
		my_nominal_values.addElement("third");

		Attribute position = new Attribute("class", my_nominal_values);
		System.out.println(position);

	}
	
	private void Instances()
	{
//		Instance newInstance = null;
//		for(int i = 0 ; i<10 ; i++)
//		{
//		    newInstance.setValue(i , 0.5);
//		    //i is the index of attribute
//		    //value is the value that you want to set
//		 }
//		 //add the new instance to the main dataset at the last position
//		System.out.println(newInstance);
		
		Random rand = new Random();
		
		for(int i=0; i<instnace_num.length; i++)
		{
			instnace_num[i] = rand.nextInt();
			instnace_str += String.valueOf(instnace_num[i]+",");
		}
	
		// ------------------------------------------------------
		// 2. create Instances object
		// Sample
		double[] instanceValue1 = new double[dim];
	    instanceValue1[0] = 244;
	    instanceValue1[1] = 59;
	    instanceValue1[2] = 2;
	    instanceValue1[3] = 880606923;

	    DenseInstance denseInstance1 = new DenseInstance(1.0, instanceValue1);		// attribute	// value
	    	    
	    System.out.println(denseInstance1);			
	}

	public static void main(String[] args)
	{
		Add_Data adddata = new Add_Data();
	}
	
}
