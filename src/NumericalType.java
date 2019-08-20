
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

	long thisweekInstructorCount = 1;
	long lastweekInstructorCount = 8;
	
	public NumericalType()
	{
		double differencePercentageInstructors;
		
		differencePercentageInstructors = (double)(thisweekInstructorCount - lastweekInstructorCount) / (double)lastweekInstructorCount;
		System.out.println(differencePercentageInstructors);
	}
	
	public static void main(String[] args)
	{
		NumericalType nt = new NumericalType();
	}
	
}
