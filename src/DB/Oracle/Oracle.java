package com.db.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * Reference
 * https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/313651/
 * 
 */

/*
 *  id          RAW(32) default SYS_GUID() not null,
		title       CHAR(20),
		sub_titile  CHAR(20),
		texture     CHAR(20),
		weight      NUMBER(10),
		weight_unit CHAR(10),
		price       NUMBER(10),
		market      CHAR(20),
		brand       CHAR(20),
		data_date   DATE,
		remark      CHAR(50),
		data_source CHAR(20),
		data_url    CHAR(200)
 * 
 */

public class Oracle 
{
	String dbURL = "jdbc:oracle:thin:xxx/xxx@xxx.xxx.xxx.xxx:1521:SPGD";
	
	private static String USERNAMR = "";
	private static String PASSWORD = "";
	private static String DRVIER = "oracle.jdbc.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@xxx.xxx.xxx.xxx:1521:xxxx";
	
	private Connection connection = null;		
	private PreparedStatement pstm = null;		
	private ResultSet rs = null;
	
	public Oracle() throws SQLException
	{
		// Connection check		
		// DATABASE Query
		
		Timestamp time= new Timestamp(System.currentTimeMillis());//獲取系統當前時間 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr = df.format(time); 
		time = Timestamp.valueOf(timeStr); 		
		
		// Insert Data
			//AddData("生意社","生意社","123",10,"456",10,"台灣","無",time,"無","無","無");
		// Query Data
			//Table_Data_Count();
			Query();
		
		//getTableNameList();
		//getColumnNameList();
	}
	
	private void Table_Data_Count() throws SQLException
	{
		connection = getConnection();
		
		String querysql = "SELECT count(*) FROM xxx.xxxx";
		pstm = connection.prepareStatement(querysql);
		ResultSet result = pstm.executeQuery();
		
		int count = 0;
		if (result.next()) {            
            count = result.getInt("count(*)");
        }
		System.out.println(count);
	}
	
	private void Query() throws SQLException
	{
		connection = getConnection();
				
		String sql = "SELECT * FROM xxxx.xxxx";
		
		int total_count = 0;
		int weight;
		String title;
		Timestamp time;
		
		
		pstm = connection.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		while (rs.next()) 
		{
			weight = rs.getInt("WEIGHT");
			title = rs.getString("TITLE");
			time = rs.getTimestamp("DATA_DATE");
			System.out.println(title+"	"+weight+"	"+time);
		}
		//System.out.println("count "+count);
	}
	
	private void Query_All() throws SQLException
	{
		connection = getConnection();
				
		String sql = "SELECT * FROM xxxx.xxxx";
		
		int total_count = 0;
		String texture;
		double weight;
		String title;
		Timestamp time;
		Timestamp createtime;
		
		pstm = connection.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		while (rs.next()) 
		{
			texture = rs.getString("TEXTURE");
			weight = rs.getDouble("WEIGHT");
			title = rs.getString("TITLE");
			time = rs.getTimestamp("DATA_DATE");
			createtime = rs.getTimestamp("CREATE_DATE");
			
			System.out.println(title+"	"+texture+"	"+weight+"	"+time+"	"+createtime);
		}
		//System.out.println("count "+count);
	}
	
	private void Query_Record(String title_query, double weight_query, Timestamp date_query) throws SQLException
	{
		connection = getConnection();
				
		//String sql = "SELECT * FROM xxxx.xxxx WHERE (WEIGHT) in ((" +weight_query+ "))";
		//String sql = "SELECT * FROM xxxx.xxxx WHERE WEIGHT = '" + weight_query + "' AND CREATE_DATE='"+ date_query + "'";
		String sql = "SELECT * FROM xxxx.xxxx WHERE WEIGHT = '" + weight_query + "'";
		//String sql = "SELECT * FROM xxxx.xxxx WHERE CREATE_DATE = '" + date_query + "'";
		//String sql = "SELECT * FROM xxxx.xxxx WHERE CREATE_DATE = to_timestamp('"+date_query+"', 'yyyy-MM-dd HH:mm:ss')" ;
		
		
		System.out.println(sql);
		int total_count = 0;
		String texture;
		double weight;
		String title;
		Timestamp time;
		Timestamp createtime;
		
		pstm = connection.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		while (rs.next()) 
		{
			texture = rs.getString("TEXTURE");
			weight = rs.getDouble("WEIGHT");
			title = rs.getString("TITLE");
			time = rs.getTimestamp("DATA_DATE");
			createtime = rs.getTimestamp("CREATE_DATE");
			
			System.out.println(title+"	"+texture+"	"+weight+"	"+time+"	"+createtime);
		}
		//System.out.println("count "+count);
	}
	
	public void AddData(
			String title, 
			String sub_titile, 
			String texture, 			
			int weight,
			String weight_unit,
			int price,
			String market,
			String brand,
			Timestamp data_date,
			String remark,
			String data_source,
			String data_url) throws SQLException 
	{
		
		
		connection = getConnection();		
		
		String sqlStr = "INSERT INTO xxxx.xxxx "
				+ "(TITLE, SUB_TITILE, TEXTURE, WEIGHT, WEIGHT_UNIT, PRICE, MARKET, BRAND, DATA_DATE, REMARK, DATA_SOURCE, DATA_URL) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		

			// 執行插入資料操作
			pstm = connection.prepareStatement(sqlStr);			
			pstm.setString(1, title);
			pstm.setString(2, sub_titile);
			pstm.setString(3, texture);
			pstm.setInt(4, weight);
			pstm.setString(5, weight_unit);
			pstm.setInt(6, price);
			pstm.setString(7, market);
			pstm.setString(8, brand);
			pstm.setTimestamp(9, data_date);						
			pstm.setString(10, remark);
			pstm.setString(11, data_source);
			pstm.setString(12, data_url);
			pstm.executeUpdate();
			pstm.close();
		
			System.out.println("Insert finished");
	}
	
	private void DeleteData(String title_query, double weight_query, Timestamp date_query) throws Exception
	{
		connection = getConnection();
		Statement stmt = connection.createStatement();
		
		String sql = "DELETE FROM ECAS_MGR.CA_RAW_MATERIAL_PRICE_OUTSOURCE WHERE WEIGHT = '" + weight_query + "'";		
		//System.out.println(sql);
		int total_count = 0;
		String texture;
		double weight;
		String title;
		Timestamp time;
		Timestamp createtime;
				
		stmt.executeUpdate(sql);		
		
		while (rs.next()) 
		{
			texture = rs.getString("TEXTURE");
			weight = rs.getDouble("WEIGHT");
			title = rs.getString("TITLE");
			time = rs.getTimestamp("DATA_DATE");
			createtime = rs.getTimestamp("CREATE_DATE");
			
			System.out.println(title+"	"+texture+"	"+weight+"	"+time+"	"+createtime);
		}
	}
	
	private void DeleteAllData() throws Exception
	{
		connection = getConnection();
		Statement stmt = connection.createStatement();
		
		String sql = "DELETE FROM ECAS_MGR.CA_RAW_MATERIAL_PRICE_OUTSOURCE";				
		int total_count = 0;
		String texture;
		double weight;
		String title;
		Timestamp time;
		Timestamp createtime;
				
		stmt.executeUpdate(sql);		
		
		while (rs.next()) 
		{
			texture = rs.getString("TEXTURE");
			weight = rs.getDouble("WEIGHT");
			title = rs.getString("TITLE");
			time = rs.getTimestamp("DATA_DATE");
			createtime = rs.getTimestamp("CREATE_DATE");
			
			System.out.println(title+"	"+texture+"	"+weight+"	"+time+"	"+createtime);
		}
	}
	
	private Connection getConnection() 
	{
		try {
			Class.forName(DRVIER);
			connection = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
			System.out.println("成功連線資料庫");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("class not find !", e);
		} catch (SQLException e) {
			throw new RuntimeException("get connection error!", e);
		}
		return connection;
	}
	
	private void getTableNameList() throws SQLException 
	{
		connection = getConnection();
		DatabaseMetaData dbmd = connection.getMetaData();		
		ResultSet rs = dbmd.getTables("null", "DBA", "%", new String[] { "TABLE" });
		//System.out.println("kkkkkk" dbmd.getTables("null", "%", "%", new String[] { "TABLE" }));
		List tableNameList = new ArrayList();
		while (rs.next()) 
		{
			System.out.println(rs.getString("TABLE_NAME"));
			//tableNameList.add(rs.getString("TABLE_NAME"));
		}		
	}
	
	private void getColumnNameList() throws SQLException 
	{
		connection = getConnection();
		DatabaseMetaData dbmd = connection.getMetaData();
		ResultSet rs = dbmd.getColumns(null, "%", "CA_RAW_MATERIAL_PRICE_OUTSOURCE", "%");
		//List columnNameList = new ArrayList();
		while (rs.next()) 
		{
			System.out.println(rs.getString("COLUMN_NAME"));
			//columnNameList.add(rs.getString("COLUMN_NAME"));
		}
		
	}
	
	public static void main(String[] args) 
	{
		try {
			Oracle ora = new Oracle();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
