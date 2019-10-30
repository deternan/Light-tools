package Sort;
import java.util.Arrays;

public class Sort_array 
{

	public Sort_array()
	{
		int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
		 
        Arrays.sort(arr);
 
        for(int i=0; i<arr.length; i++)
        {
        	System.out.println(arr[i]);
        }
	}
	
	public static void main(String[] args)
	{
		Sort_array sort = new Sort_array();
	}
	
}
