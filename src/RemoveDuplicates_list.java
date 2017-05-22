import java.util.ArrayList;
import java.util.List;


public class RemoveDuplicates_list 
{
	
	public RemoveDuplicates_list()
	{
		List<String> list = new ArrayList<String>();
		list.add("AAA");
		list.add("AAA");
		list.add("BBB");
		list.add("CCC");
		
		for(int i=0; i<list.size()-1; i++)  
		{
		    for(int j=list.size()-1; j>i; j--)  
		    {
		      if(list.get(j).equals(list.get(i)))  {
		        list.remove(j);
		      } 
		    } 
		} 
		System.out.println(list);
	}
	
	public static void main(String args[])
	{
		RemoveDuplicates_list rl = new RemoveDuplicates_list();
	}
	
}
