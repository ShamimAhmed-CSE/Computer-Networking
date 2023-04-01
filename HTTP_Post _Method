import java.net.*;
import java.util.*;
import java.nio.charset.*;
import java.io.*;
  
public class HttpRequest {
    
    
    String result = "";
    
    HttpRequest(String _url, String _method, Map<String, String> _postData, String _contentType) {
        
        try {
            URL url = new URL( _url );
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod(_method); // PUT is another valid option
            http.setDoOutput(true);         
            
            StringJoiner sj = new StringJoiner("&");
            for(Map.Entry<String,String> entry : _postData.entrySet())
                sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + entry.getValue());
                //sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue()));
            byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", _contentType);
            http.setRequestProperty( "charset", "utf-8");
            http.setRequestProperty( "Content-Length", Integer.toString( length ));
            http.setInstanceFollowRedirects( false );
            http.setUseCaches( false );
            http.connect();
            try(OutputStream os = http.getOutputStream()) {
                os.write(out);
            }
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                  result = result + line;
                }
            }
          } else {
            System.out.println("Bad response!");
          }
        }catch (IOException e) {
            // writing exception to log
            e.printStackTrace();
        }
        
    }
    
    
    HttpRequest(String _url, String _method, Map<String, String> _postData) {
        this(_url, _method, _postData, "text/html");
    }
    
    HttpRequest(String _url, String _method) {
        this(_url, _method, new HashMap<String, String>());
    }
    
    HttpRequest(String _url) {
        this(_url, "GET");
    }
    
    
    public String toString() {
        return result;
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, String> postData = new HashMap<String, String>();
        postData.putIfAbsent("email", "test@test.com");
        postData.putIfAbsent("password", "test");
        
        HttpRequest result = new HttpRequest("https://httpbin.org/anything", "POST", postData, "application/x-www-form-urlencoded");
        System.out.println(result.toString());
    }
}
