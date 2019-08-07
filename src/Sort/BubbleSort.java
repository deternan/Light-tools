package Sort;

public class BubbleSort 
{
	
	public BubbleSort(double[] input)
	{
		int lenD = input.length;
		int j = 0;
		double tmp = 0;
		
		for(int i=0; i<lenD; i++)
		{
		    j = i;
		    for(int k=i; k<lenD; k++)
		    {
		      if(input[j] < input[k]){
		        j = k;		        
		      }
		    }
		    // Numerical
		    tmp = input[i];		   
		    input[i] = input[j];
		    input[j] = tmp;		   
		}
		
		for(int i=0;i<input.length;i++) {
			System.out.println(input[i]);
		}
	}
	
	public static void main(String args[]) {
		double[] input = {1,5,4,20,19,0,3};
		BubbleSort bs = new BubbleSort(input);
	}
	
}