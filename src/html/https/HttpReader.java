package https;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpReader extends HtmlReader{
    public String root;
    public String subUrl;
    public String charSet;
    public HashMap QueryHash;
    public String referer;

    public HttpReader() {
        HttpReaderInit();
    }

    public void HttpReaderInit(){
        charSet = "utf-8";
        subUrl = "";
        referer = null;
        QueryHash = new HashMap();
    }

     
    public InputStream getInputStream(String urlPath,String cookie,boolean isRedirect) throws IOException{
        URL url = new URL(urlPath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-agent","IE/7.0");
        connection.setRequestProperty("Cookie", cookie == null ? "" :cookie);
       
        connection.setInstanceFollowRedirects(isRedirect);

        connection.connect();
        headerFields.clear();
        //System.out.println(connection.getHeaderFields());
        if(connection.getHeaderFields() != null){
            headerFields.putAll(connection.getHeaderFields());
        }
        
        if("gzip".equalsIgnoreCase( connection.getContentEncoding())){
            return new GZIPInputStream(connection.getInputStream());
        }
        return connection.getInputStream();
    }

    public InputStream openURL(String url,String data,String cookie,String referer,boolean post,boolean isRedirect) throws IOException{
        URL tmpurl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) tmpurl.openConnection();

        connection.setDoOutput(true);
        connection.setDoInput(true);
        if(post){
            connection.setRequestMethod("POST");
        }
        connection.setUseCaches(false);
        connection.setAllowUserInteraction(true);
        //HttpURLConnection.setFollowRedirects(true);
        connection.setInstanceFollowRedirects(isRedirect);

        connection.setRequestProperty("User-agent",getRequestProperty("User-agent"));
        connection.setRequestProperty("Accept",getRequestProperty("Accept"));
        connection.setRequestProperty("Accept-Language",getRequestProperty("Accept-Language"));
        connection.setRequestProperty("Accept-Charse",getRequestProperty("Accept-Charse"));
        if (cookie != null){
            connection.setRequestProperty("Cookie", cookie);
        }
        if (referer != null) {
            connection.setRequestProperty("Referer", referer);
        }

        if(post){
            connection.setRequestProperty("Content-Type", getRequestProperty("Content-Type"));
            
            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
            //String mStr = new String(data.getBytes(charSet), charSet);
            dos.write(data.getBytes(charSet));//2012/12/15 修正傳送資料未加上byte格式轉換
            dos.flush();
            
            dos.close();
        }
        headerFields.clear();
        
        headerFields.putAll(connection.getHeaderFields());//取得回傳的標頭資料
        if("gzip".equalsIgnoreCase( connection.getContentEncoding())){
            return new GZIPInputStream(connection.getInputStream());
        }
		
        return connection.getInputStream();
    }
    
    

    /**
     * 設定post、get要送的資料
     * get為串在?後面的參數
     * @param name
     * @param value
     */
    public void putQueryString(String name, String value){
        QueryHash.put(name, value);
    }

    /**
     * 取得記錄的QueryString
     * @param name
     * @return
     */
    public String getQueryField(String name){
        return (String)QueryHash.get(name);
    }

    /**
     * 取出post資料串成字串
     * @return
     */
    public String getQueryString(boolean post){
        StringBuffer data = new StringBuffer();
        HashMap postData = (HashMap)QueryHash.clone();
        Set set = postData.entrySet();
        Iterator t = set.iterator();

        while(t.hasNext()) {
            Map.Entry m = (Map.Entry)t.next();
            if(data.length() > 0){
                data.append("&" + m.getKey() + "=" + m.getValue());
            }else{
                data.append(m.getKey() + "=" + m.getValue());
            }
        }

        if(!post){
            return "?" + data.toString();
        }
        return data.toString();
    }

    /**
     * 取得網頁標頭資料，並準備開始網頁
     * @param cookie
     * @return
     */
    public BufferedReader readyBuffer(String cookie,boolean post){
        BufferedReader rd = null;
        try{
            InputStream inputstream = openURL(root + subUrl, getQueryString(post), cookie, referer, post);
            substringHeader();
            rd = new BufferedReader(new InputStreamReader(inputstream,charSet));

        }catch(Exception e){
            e.printStackTrace();
        }
        return rd;
    }

    /**
     * 取得存放html的ArrayList
     * @param url
     * @param cookie
     * @return
     */
    public ArrayList getArrayList(String url,String cookie){
        return getHTMLtoArrayList(url, charSet,cookie);
    }

    /**
     * 取得網頁html 字串
     * @param url
     * @param cookie
     * @return
     */
    public String getHtmlString(String url,String cookie){
        return getHTML(url, charSet,cookie);
    }

    /**
     * 清除postdataHash裡所有的資料
     */
    public void clearPostData(){
        QueryHash.clear();
    }



}
