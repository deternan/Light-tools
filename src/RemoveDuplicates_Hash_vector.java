
import java.util.LinkedHashSet;
import java.util.Vector;

/*
 * Reonve duplication (vector) based on Hash
 * 
 * version: April 14, 2017 02:02 PM
 * Last revision: October 24, 2017 11:33 AM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

public class RemoveDuplicates_Hash_vector 
{
	Vector test = new Vector();
	
	public RemoveDuplicates_Hash_vector()
	{
		test.add("pen");
		test.add("Pineapple");
		test.add("apple");
		test.add("pen");	
		
		Vector newVect = new Vector(new LinkedHashSet(test));
		
		
		for(int i=0; i<newVect.size(); i++)
		{
			System.out.println(newVect.get(i));
		}
	}
	
	public static void main(String args[])
	{
		RemoveDuplicates_Hash_vector rv = new RemoveDuplicates_Hash_vector();
	}
	
}
