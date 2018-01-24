package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Cloud_Vision 
{
	private String key = "";
	
	public Cloud_Vision()
	{
		StringBuilder result = new StringBuilder();
        try {
            //String encodedText = URLEncoder.encode(text, "UTF-8");
            String urlStr = "https://vision.googleapis.com/v1/images:annotate?key=" + key ;
 
            URL url = new URL(urlStr);
 
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            InputStream stream;
            if (conn.getResponseCode() == 200) //success
            {
                stream = conn.getInputStream();
            } else
                stream = conn.getErrorStream();
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
 
//            JsonParser parser = new JsonParser();
// 
//            JsonElement element = parser.parse(result.toString());
// 
//            if (element.isJsonObject()) {
//                JsonObject obj = element.getAsJsonObject();
//                if (obj.get("error") == null) {
//                    String translatedText = obj.get("data").getAsJsonObject().
//                    get("translations").getAsJsonArray().
//                    get(0).getAsJsonObject().
//                    get("translatedText").getAsString();
//                    
//                }
//            }
 
            if (conn.getResponseCode() != 200) {
                System.err.println(result);
            }else{
            	System.err.println(result);
            }
 
        } catch (IOException | JsonSyntaxException ex) {
            System.err.println(ex.getMessage());
        }
 
        //return null;
	}
	
	public static void main(String args[])
	{
		Cloud_Vision gcv = new Cloud_Vision();
	}
	
}
