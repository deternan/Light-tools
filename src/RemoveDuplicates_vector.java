import java.util.LinkedHashSet;
import java.util.Vector;

public class RemoveDuplicates_vector 
{
	Vector test = new Vector();
	
	public RemoveDuplicates_vector()
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
		RemoveDuplicates_vector rv = new RemoveDuplicates_vector();
	}
	
}
