package Weka;

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
	
	public Add_Data()
	{
		// Create numeric attributes "length" and "weight" 
//		Attribute length = new Attribute("length"); 
//		Attribute weight = new Attribute("weight"); 

		//Attributes();		
		//Class();
		Instances();
	}
	
	private void Attributes()
	{
		Attribute a1 = new Attribute("sepallength", 0);
        Attribute a2 = new Attribute("REAL", 1);       
        
        FastVector attrs = new FastVector();
		attrs.addElement(a1);
		attrs.addElement(a2);
		
		System.out.println(attrs.get(0));
		System.out.println(attrs.get(1));
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

		System.out.println(position);
	}
	
	private void Instances()
	{
		
	}
	
	public static void main(String[] args)
	{
		Add_Data adddata = new Add_Data();
	}
	
}
