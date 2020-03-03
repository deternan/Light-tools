
/*
 * https parser
 * 
 * version: March 04, 2020 01:02 AM
 * Last revision: March 04, 2020 01:12 AM
 * 
 * Author : Chao-Hsuan Ke
 * Email: phelpske.dev at gmail dot com
 */

public class TestHTMLParser 
{
	private String URL = "http://newsapi.org/v2/everything?q=bitcoin&from=2020-02-03&sortBy=publishedAt&apiKey=";
	
	
	public TestHTMLParser()
	{
		try {
	        String sCurrentLine;
	        String sTotalString;
	        sCurrentLine = "";
	        sTotalString = "";
	        java.io.InputStream l_urlStream;
	        java.net.URL l_url = new java.net.URL(URL);
	        java.net.HttpURLConnection l_connection = (java.net.HttpURLConnection) l_url.openConnection();
	        l_connection.connect();
	        l_urlStream = l_connection.getInputStream();
	        java.io.BufferedReader l_reader = new java.io.BufferedReader(new java.io.InputStreamReader(l_urlStream));
	        while ((sCurrentLine = l_reader.readLine()) != null) {
	          sTotalString = sCurrentLine; //"/r/n";
	          System.out.println(sTotalString);
	        }
	        
	        //String testText = extractText(sTotalString);
	        //System.out.println( testText );
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


  
  public static void main(String[] args) throws Exception 
  {
    // test5(“http://www.google.com”);
	  TestHTMLParser test = new TestHTMLParser();
  }
  
}
