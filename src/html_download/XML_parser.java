/*
 * XML get and parser
 * 
 * version: June 08, 2017 01:07 AM
 * Last revision: June 08, 2017 08:21 PM,
 * 
 * 氣象資料
 * 自動氣象站-氣象觀測資料			O-A0001-001
 * 自動雨量站-雨量觀測資料			O-A0002-001
 * 酸雨pH值-每日酸雨pH值				O-A0004-001
 * 紫外線指數-每日紫外線指數最大值	O-A0005-001
 * 溫度分布圖-溫度分布圖				O-A0038-001		(PIC)
 * 局屬氣象站-現在天氣觀測報告		O-A0003-001
 * 
 */


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XML_parser 
{
	// Get
	private final String USER_AGENT = "Mozilla/5.0";
	// CWB
	private String dataid = "O-A0003-001";;
	private String key = "";
	
	public XML_parser() throws Exception
	{
		httpsendGet();
		
	}
	
	private void httpsendGet() throws Exception 
	{
		String url = "http://opendata.cwb.gov.tw/opendataapi?dataid="+ dataid +"&authorizationkey="+key;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		Parser(response.toString());
		//print result
		//System.out.println(response.toString());
	}
	
	private void Parser(String input_str) throws Exception
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        InputStream inputStream = new ByteArrayInputStream(input_str.getBytes());
        Document doc = builder.parse(inputStream); //
        
        Element root = doc.getDocumentElement(); // Element
        NodeList location = root.getElementsByTagName("location");
        
        System.out.println("location length: "+location.getLength());            
        
        for (int i=0; i<location.getLength(); i++) {
            // 
            Element ele = (Element) location.item(i);
            
            // location name
            NodeList names = ele.getElementsByTagName("locationName");
            Element e = (Element) names.item(0);
            Node t = e.getFirstChild();
            System.out.println(t.getNodeValue());
            
//            System.out.println("locationName: "+ele.getAttribute("locationName"));            
        }
	}
	
	public static void main(String[] args) 
	{
		try {
			XML_parser xml = new XML_parser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
