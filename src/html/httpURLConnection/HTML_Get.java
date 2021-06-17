
/*
 * https parser
 * 
 * version: March 04, 2020 01:02 AM
 * Last revision: March 04, 2020 10:58 PM
 * 
 * Author : Chao-Hsuan Ke
 * Email: phelpske.dev at gmail dot com
 */

/*
 * Reference
 * 
 * https://newsapi.org/docs/endpoints/top-headlines
 */

public class HTML_Get 
{	
	private String basedURL = "http://newsapi.org/v2/top-headlines?";
	
	private String country = "tw";
	private String category = "health";	
	private String apiKey = "";
	private String URL = "";
	
	public HTML_Get()
	{
		URL = basedURL + "country=" + country + "&category=" + category + "&apiKey=" + apiKey;
		
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
	        
	        while ((sCurrentLine = l_reader.readLine()) != null) 
	        {
	          sTotalString = sCurrentLine; 
	          System.out.println(sTotalString);
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


  
  public static void main(String[] args) throws Exception 
  {
    // test5(“http://www.google.com”);
	  HTML_Get test = new HTML_Get();
  }
  
}
