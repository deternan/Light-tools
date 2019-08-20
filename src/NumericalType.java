
/*
 * numerical type testing
 * 
 * version: August 20, 2019 11:55 PM
 * Last revision: August 20, 2019 11:55 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

public class NumericalType 
{

	long thisweekInstructorCount = 3;
	long lastweekInstructorCount = 1;
	
	public NumericalType()
	{
		double differencePercentageInstructors;
		
		if ((lastweekInstructorCount == 0f) && (thisweekInstructorCount > 0f)) {
			differencePercentageInstructors = 1.0;
		}else if((lastweekInstructorCount!= 0f) && (thisweekInstructorCount == 0f)) {
			differencePercentageInstructors = 0;
		}else if ((lastweekInstructorCount == 0f) && (thisweekInstructorCount == 0f)){
			differencePercentageInstructors = 0;
		}else {
			differencePercentageInstructors = (double)(thisweekInstructorCount - lastweekInstructorCount) / (double)lastweekInstructorCount;
		}
		
		
		System.out.println(differencePercentageInstructors);
	}
	
	public static void main(String[] args)
	{
		NumericalType nt = new NumericalType();
	}
	
}
