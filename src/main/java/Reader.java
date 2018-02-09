import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Reader {
    public  static String ReadConnection(String from, String to) throws Exception {
//        String url = "http://api.fixer.io/latest?base="+from.toUpperCase()+"&symbols="+to.toUpperCase();
        String url="https://api.fixer.io/latest";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null)
        {
            response.append(inputLine);
        }
        in.close();

        return  response.toString();
    }

}
