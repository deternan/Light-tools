package Weka;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.filters.unsupervised.attribute.Add;

/*
 * Generated arff dataset
 * 
 * version: December 12, 2017 05:37 PM
 * Last revision: December 12, 2017 05:37 PM
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
	
	// output
	private String output_folder = "C:\\Users\\Barry.Ke\\Desktop\\";
	private String output_file = "AAA.txt";		
	String instnace_str = "";
	
	public Add_Data()
	{
		// Create numeric attributes "length" and "weight" 
//		Attribute length = new Attribute("length"); 
//		Attribute weight = new Attribute("weight"); 

		Attributes();		
		Class();
		Instances();
	}
	
	private void Attributes()
	{
		
        Attribute a1 = new Attribute("REAL", 1);       
        
        FastVector attrs = new FastVector();
		attrs.addElement(a1);		
		
		System.out.println(attrs.get(0));
		
	}
	
	private void Class()
	{
		// Create vector to hold nominal values "first", "second", "third" 
		FastVector my_nominal_values = new FastVector(3);
		my_nominal_values.addElement("first");
		my_nominal_values.addElement("second");
		my_nominal_values.addElement("third");

		// Create nominal attribute "position"
		Attribute position = new Attribute("class", my_nominal_values);

		System.out.println(position.getRevision());
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
		
	}
	
	private void output()
	{
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_folder + output_file), "utf-8"));
			writer.write("QQQ");
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Add_Data adddata = new Add_Data();
	}
	
}
