package API.admindashboard.InsertMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.MongoClient;

/*
 * Get eTube video (data: 35)
 * 
 * version: December 18, 2017 10:28 AM
 * Last revision: April 30, 2018 11:50 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */


public class Get_allvideo_Insert extends Parameters
{
	MongoClient mongoClient = new MongoClient(host, port);
	DB db = mongoClient.getDB(dbName);	
	// Query
    private DBCollection dbcollection = db.getCollection(video_colName);
   
    // 
    String videoId = "";
    String userId = "";
    String itemType = "video";
    boolean deletedState;
    String videoType = "";
    String permission = "";
    String category = "";
    int viewCount = 0;
    int likeCount = 0;
    int shareCount = 0;
    //String updatedTimeStamp;
    Date updatedTimeStamp;		java.sql.Date tt;
    //String createdTimeStamp = "";
    String addedTimeStamp;
    String externalSource = "";
    
    //SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.TAIWAN);
    //TimeZone tz = TimeZone.getTimeZone("Asia/Taipei");
    //DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.TAIWAN);
    
    // MySQL    
    Connection conn = DriverManager.getConnection(myUrl, account, pass);
    String insert_query = "";
    
	public Get_allvideo_Insert() throws Exception
	{		
		// MySQL
		Class.forName(JDBC_DRIVER);	    
	    // the mysql insert statement
	    insert_query = " insert into new_video (videoId, userId, itemType, deletedState, videoType, permission, category, viewCount, likeCount, shareCount, updatedTimeStamp, addedTimeStamp, externalSource)"+ 
	    	    " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		MongoDB_get_videos();
		
		conn.close();
	}
	
	private void MongoDB_get_videos() throws Exception
	{					
		BasicDBObject videoQuery = new BasicDBObject();
		videoQuery.put(uploadStatus, uploadStatus_success);
		//videoQuery.put("permission", "public");
		//videoQuery.put("publishedStatus", true);
		//videoQuery.put("deletedStatus", false);
		//videoQuery.put("videoType", "originalVideo");
		
		DBCursor cursor = dbcollection.find(videoQuery);		
		// sort
		BasicDBObject latestQuery = new BasicDBObject();
		latestQuery.put("publishedTimeStamp", 1);
		cursor.sort(latestQuery);
		//System.out.println(cursor.count());
		int count = 0;
						
		while(cursor.hasNext())
		{												
			Clean();
			
			DBObject obj = cursor.next();			
														
			videoId = obj.get("_id").toString();		    
			userId = DBRef_userId(obj);
		    //itemType
			deletedState = Boolean.valueOf(obj.get("deletedStatus").toString());
		    videoType = obj.get("videoType").toString();
		    permission = obj.get("permission").toString();
		    if(obj.containsField("category")){
		    	 category = obj.get("category").toString();
		    }
		    if(obj.containsField("viewCount")){
		    	viewCount = Integer.parseInt(obj.get("viewCount").toString());
		    }		    
		    likeCount = Integer.parseInt(obj.get("likeCount").toString());
		    shareCount = Integer.parseInt(obj.get("shareCount").toString());
		    if(obj.containsField("updatedTimeStamp")){
		    	
		    	String temp = obj.get("updatedTimeStamp").toString();
		    	//updatedTimeStamp = obj.get("updatedTimeStamp");
		    	//System.out.println(aa);
		    	System.out.println(temp);		// Thu Apr 12 15:54:11 CST 2018
		    	//tt = (java.sql.Date) TestDate(obj.get("updatedTimeStamp").toString());
		    	//System.out.println(tt);
		    	TestDate(obj.get("updatedTimeStamp").toString());
		    	//updatedTimeStamp = fromISO8601UTC(temp);
		    	//updatedTimeStamp = obj.get("updatedTimeStamp").toString();
		    	
		    }
		    if(obj.containsField("addedTimeStamp")){
		    	addedTimeStamp = obj.get("addedTimeStamp").toString();
		    }
		    if(obj.containsField("externalSource")){
		    	externalSource = obj.get("externalSource").toString();
		    }
		    //createdTimeStamp = obj.get("itemType").toString();
		    		     
		    
//		    InsertMySQL();
		    
		    //System.out.println(userId+"	"+obj.get("_id")+"	"+itemType+"	"+permission+"	"+videoType+"	"+updatedTimeStamp);
		}
		
		cursor.close();
		mongoClient.close();
	}
	
	private void InsertMySQL() throws Exception
	{
		// create the mysql insert preparedstatement
	    PreparedStatement preparedStmt = conn.prepareStatement(insert_query);
	    preparedStmt.setString(1, videoId);
	    preparedStmt.setString(2, userId);
	    preparedStmt.setString(3, itemType);		    
	    preparedStmt.setBoolean(4, deletedState);
	    preparedStmt.setString(5, videoType);
	    preparedStmt.setString(6, permission);   
	    preparedStmt.setString(7, category);		 
	    preparedStmt.setInt(8, viewCount);
	    preparedStmt.setInt(9, likeCount);
	    preparedStmt.setInt(10, shareCount);  		    
	    //preparedStmt.setString(11, updatedTimeStamp);
	    //preparedStmt.setDate(11, (java.sql.Date) updatedTimeStamp);
	    preparedStmt.setDate(11, tt);
	    preparedStmt.setString(12, addedTimeStamp);
	    preparedStmt.setString(13, externalSource);
	    
	    // execute the preparedstatement		    
	    preparedStmt.execute();
	}
	
	private String DBRef_userId(DBObject obj)
	{
		String userid = "";
		
		Object id = obj.get("user");		
		if (id instanceof DBRef) {				
		   DBRef ref=(DBRef)id;
		   id = ref.getId();
		   userid = ref.getId().toString();
		   //System.out.println(id);
		 }
		
		return userid;
	}
	
	private void TestDate(String inputdate) throws ParseException
	{
		//String lastCrawlDate = "2014-01-28";
		//Date utilDate = new SimpleDateFormat("EEE MMM dd hh:mm:ss ZZZ yyyy").parse(inputdate);
		SimpleDateFormat utilDate = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.TAIWAN);
		//System.out.println(utilDate);
		// because PreparedStatement#setDate(..) expects a java.sql.Date argument
		//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		java.sql.Date sDate = null;
		java.util.Date date3 = utilDate.parse(inputdate);
		sDate = new java.sql.Date(date3.getTime());
		System.out.println(sDate);
		//return sqlDate;
	}
	
	private DateFormat fromISO8601UTC(String dateStr) 
	{
		  TimeZone tz = TimeZone.getTimeZone("Asia/Taipei");
		  //DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		  DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy");
		  df.setTimeZone(tz);
		  
		  return df;		  
	}
	
	private void Clean()
	{
		videoId = "";
	    userId = "";
	    //itemType = "";
	    deletedState = false;
	    videoType = "";
	    permission = "";
	    category = "";
	    viewCount = 0;
	    likeCount = 0;
	    shareCount = 0;
	    //updatedTimeStamp = "";
	    updatedTimeStamp = null;
	    tt = null;
	    //createdTimeStamp = "";
	    addedTimeStamp = "";
	    externalSource = "";
	}
	
	public static void main(String[] args)
	{
		try {
			Get_allvideo_Insert allvideos = new Get_allvideo_Insert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
