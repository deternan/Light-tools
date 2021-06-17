public class HttpURLConnection
{
 
  private String urlsite ="http://www.zzcylyj.com/list_2462.html";
  
  public HttpURLConnection()
  {
    
    HttpURLConnection c = null;
        URL u = new URL(urlsite);
        c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET");
        c.setRequestProperty("Content-length", "0");
        c.setUseCaches(false);
        c.setAllowUserInteraction(false);
        //c.setConnectTimeout(timeout);
        //c.setReadTimeout(timeout);
        c.connect();
        int status = c.getResponseCode();

        switch (status) 
        {
            case 200:
            case 201:
                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) 
                {
                    //sb.append(line+"\n");
                	System.out.println(line);
                }
                br.close();
                //return sb.toString();
        }
	}
  }
  
}
