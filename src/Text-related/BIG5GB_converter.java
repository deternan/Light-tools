package Text_related;

/*
 * Traditional Chinese and Simplified Chinese Converter 
 * 
 * version: September 02, 2019 09:40 AM
 * Last revision: September 02, 2019 09:50 AM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

/*
 * JAR
 * ZHConverter.jar
 * 
 */

import com.spreada.utils.chinese.ZHConverter;

public class BIG5GB_converter
{
	String traStr = "AI 大腦算出最佳路徑，戶戶送 26 分鐘精準送上美味";
	String simStr = "新长征路上重整行装再出发";
	
	public BIG5GB_converter()
	{
		// BIG5 to GB
		ZHConverter simconverter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED); 
		String simStrResult = simconverter.convert(traStr);
		System.out.println(simStrResult);
		
		// GB to BIG5
		ZHConverter traconverter = ZHConverter.getInstance(ZHConverter.TRADITIONAL);
		String traStrResult = traconverter.convert(simStr);
		System.out.println(traStrResult);
	}
	
	public static void main(String args[]) 
	{
		BIG5GB_converter bg = new BIG5GB_converter();
	}
	
}
