package Json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.XML;

public class XML_to_JSON 
{
	private String read_file_path = "";
	private String read_file_name = "*.xml";
	
	private String write_file_path = "";
	private String write_file_name = "*.json";
		
	private JSONObject jsonObj;
	
	public XML_to_JSON() throws Exception
	{
		File file = new File (read_file_path + read_file_name);
        InputStream inputStream = new FileInputStream(file);
        StringBuilder builder =  new StringBuilder();
        int ptr = 0;
        while ((ptr = inputStream.read()) != -1 )
        {
            builder.append((char) ptr);            
        }
        String xml  = builder.toString();
        jsonObj = XML.toJSONObject(xml);
        //System.out.println(jsonObj);

        Write_Line_file();
        System.out.println("Convert OK");
	}
	
	private void Write_Line_file() throws Exception
	{
		FileWriter fw = new FileWriter(write_file_path + write_file_name);
		//Replace_brackets();
		fw.write(jsonObj.toString());
		fw.flush();
		fw.close();
	}
	
	public static void main(String[] args)
	{
		try {
			XML_to_JSON xtj= new XML_to_JSON();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
