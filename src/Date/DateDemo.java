
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
  
public class DateDemo 
{
 
	public DateDemo() throws Exception
	{
//		SimpleDateFormat sdf = new SimpleDateFormat("E yyyy/MM/dd");
//
//		// 利用 DateFormat 來parse 日期的字串
//		DateFormat df = DateFormat.getDateInstance();
//		Date date = df.parse("2009/1/1");
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		System.out.println(sdf.format(calendar.getTime()));
//
//		// 利用 set 直接輸入日期
//		calendar.set(2009, Calendar.JANUARY, 1);
//		System.out.println(sdf.format(calendar.getTime()));
//
//		// 直接格式化輸出現在時間的方法
//		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
//		Date current = new Date();
//		System.out.println(sdFormat.format(current));
		
//		String date = "07-04-2077 09:24:01";
//		SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
//		Date myDate = fmt.parse(date); 
//
//		System.out.println(myDate);  //Mon Jun 04 07:05:00 EDT 2007
//		long timestamp = myDate.getTime();
//		System.out.println(timestamp);
//				
//		System.out.println("获取系统毫秒数方法1："+Long.toString(new Date().getTime()));
//		
//		
		Calendar c=Calendar.getInstance();
        long milliseconds=c.getTimeInMillis();
        System.out.println("当前时间毫秒值:"+milliseconds);
        //当前时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        System.out.println("直接格式化毫秒值输出:"+sdf.format(milliseconds));
//        //2011-08-20 04:27:16
//        Date d=new Date(milliseconds);
//        //转换成Date对象
//        System.out.println("Date对象输出时间:"+sdf.format(d));
//        Calendar c2=Calendar.getInstance();
//        System.out.println("Calendar设置前毫秒值:"+c2.getTimeInMillis());
//        c2.setTime(d);
//        //通过setTime方法转换回Calendar对象
//        System.out.println("Calendar设置后毫秒值:"+c2.getTimeInMillis());
		 
        String date = "07-04-2017 09:30";
        SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        Date myDate = fmt.parse(date); 

        System.out.println(myDate);  
        long timestamp = myDate.getTime();
        System.out.println(timestamp);
	}
	
	public static void main(String args[]) throws Exception {
//       // Instantiate a Date object
//       Date date = new Date();        
//       // display time and date using toString()
//       System.out.println(date.toString());
	   
		DateDemo dd = new DateDemo();
	   	   
   }
}
