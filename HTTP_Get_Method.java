import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Main {
    public static void main(String[] args) {
        try {
            Main.call_me();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void call_me() throws Exception
    {
        String url = "https://api.ip2location.io/?ip=103.112.206.47&key=24a047958fa460a753b2cf6b6181c0cd";
        URL obj = new URL(url);
        HttpURLConnection cn = (HttpURLConnection) obj.openConnection();

        cn.setRequestMethod("GET");

        int responseCode = cn.getResponseCode();

        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(cn.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null)
        {
            response.append(inputLine);
        }

        System.out.println("\n");

        System.out.println(response.toString());
    }
}
