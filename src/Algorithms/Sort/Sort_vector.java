package Algorithms.Sort;
import java.util.Collections;
import java.util.Vector;

public class Sort_vector 
{

	public Sort_vector()
	{
		Vector temp = new Vector();
		temp.add("abc");
		temp.add("bca");
		temp.add("cab");
		temp.add("cba");
		temp.add("abcbc");
				
		// Sort
		Collections.sort(temp);
		
		for(int i=0; i<temp.size(); i++)
		{
			System.out.println(temp.get(i));
		}
	}
	
	public static void main(String args[])
	{
		Sort_vector sort = new Sort_vector();
	}
	
}
