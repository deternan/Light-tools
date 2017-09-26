package Text_related;

/*
 * 
 * version: September, 2017 03:52 PM
 * Last revision: September, 2017 03:52 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_expression 
{

	public Regular_expression()
	{
		String pattern = "";
		String text = "";
		Pattern p;
		Matcher m;
		
		System.out.println("====== Match URL ==========");
        //pattern = "http://[\\w/\\.]{5,100}";
		pattern = "http://[\\w/\\.\\:]{5,100}";
        //text = "URL of KMIT is http://www.kmit.edu.tw/, URL of ccc is http://ccc.kmit.edu.tw/";
        text = "{verb:{id:http://adlnet.gov/expapi/verbs/read,display:{en-US:read}},object:{objectType:Activity,id:http://www.proera.com.tw/course/594/content/chapter/lecture/2974,definition:{name:{en-US:Tell your own learning story through xAPI},description:{en-US:Tell your own learning story through xAPI},type:http://activitystrea.ms/schema/1.0/article}},result:{success:true,extensions:{http://www.proera.com.tw/time:5809,http://www.proera.com.tw/startTime:2014-07-30T02:55:32.012Z,http://www.proea.com.tw/endTime:2014-07-30T02:55:37.821Z}},context:{instructor:{objectType:Agent,name:teacher,mbox:mailto:teacher@XX},contextActivities:{parent:[{objectType:Activity,id:http://www.proera.com.tw/course/594,definition:{name:{en-US:Learning Architect},description:{},type:http://adlnet.gov/expapi/activities/course}}],category:[{objectType:Activity,id:http://www.proera.com.tw/course/content,definition:{name:{en-US:content},description:{},type:http://activitystrea.ms/schema/1.0/page}}]},platform:proera},timestamp:2014-07-30T02:55:28.420Z,stored:2014-12-16T06:51:52.469Z,version:1.0.0}";
        p = Pattern.compile(pattern);
        m = p.matcher(text);
        while (m.find()) 
        {
            System.out.println(text.substring(m.start(), m.end()));
        }
	}
	
	public static void main(String[] a)
	{
		Regular_expression RE = new Regular_expression();
	}
	
}


