import java.util.Vector;


/*
 * Reonve duplication (vector) 
 * 
 * version: October 24, 2017 11:33 AM
 * Last revision: October 24, 2017 11:33 AM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

public class RemoveDuplicates_vector 
{
	Vector test = new Vector();
	
	public RemoveDuplicates_vector()
	{
		test.add("pen");
		test.add("Pineapple");
		test.add("apple");
		test.add("pen");	
				
		for (int i = 0; i < test.size(); i++) {
			for (int j = 0; j < test.size(); j++) {
				if (i != j) {
					if (test.elementAt(i).equals(test.elementAt(j))) {
						test.removeElementAt(j);
					}
				}
			}
		}
		
	}

	public static void main(String args[])
	{
		RemoveDuplicates_vector rv = new RemoveDuplicates_vector();
	}
	
}
