

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

/*
 * Google Translation
 * This example transfer the "Traditional Chinese" to "English"
 * 
 * version: February 23, 2017		04:11 PM
 * Last revision: March 07, 2017	05:46 PM
 * 
 */

/*
 * JAR
 * gson-2.3.jar
 * 
 */

public class GoogleTranslate
{
	/*
	 * how to apply the key in Google, please reference to https://cloud.google.com/
	 * detail see: https://cloud.google.com/translate/
	 */
	private String key = "";
	
	public String Translation(String text, String from, String to)
	{
		StringBuilder result = new StringBuilder();
        try {
            String encodedText = URLEncoder.encode(text, "UTF-8");
            String urlStr = "https://www.googleapis.com/language/translate/v2?key=" + key + "&q=" + encodedText + "&target=" + to + "&source=" + from;
 
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
 
            JsonParser parser = new JsonParser();
 
            JsonElement element = parser.parse(result.toString());
 
            if (element.isJsonObject()) {
                JsonObject obj = element.getAsJsonObject();
                if (obj.get("error") == null) {
                    String translatedText = obj.get("data").getAsJsonObject().
                    get("translations").getAsJsonArray().
                    get(0).getAsJsonObject().
                    get("translatedText").getAsString();
                    return translatedText;

                }
            }
 
            if (conn.getResponseCode() != 200) {
                System.err.println(result);
            }
 
        } catch (IOException | JsonSyntaxException ex) {
            System.err.println(ex.getMessage());
        }
 
        return null;
	}
	
	
	public static void main(String args[])
	{
		String input_text = args[0];
		String trans_source = "zh-TW";
		String trans_objec = "en";
		
		GoogleTranslate translator = new GoogleTranslate();        
		String text = translator.Translation(input_text, trans_source, trans_objec);
        System.out.println(text);
	}	
	
}
