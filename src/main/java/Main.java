import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception {
        String [] ar = {"EUR","AUD","CAD","CHF", "CYP", "CZK", "DKK", "EEK", "GBP", "HKD", "HUF", "ISK", "JPY", "KRW",
                "LTL", "LVL", "MTL", "NOK", "NZD", "PLN", "RON", "SEK", "SGD", "SIT", "SKK", "TRL", "USD", "ZAR","RUB"};
        Scanner in = new Scanner(System.in);
        String from,to;
        do
        {
            System.out.println("Enter from currency");
            from = in.nextLine();
            System.out.println("Enter to currency");
            to = in.nextLine();
        }while (!CheckConvert(from,ar) | !CheckConvert(to, ar));
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(RateObject.class, new RatesDeserializer())
                .create();
        String k = Reader.ReadConnection(from,to).toString();
        System.out.println(k);
        ApiResponse response = gson.fromJson(Reader.ReadConnection(from,to), ApiResponse.class);
        System.out.println(from.toUpperCase()+" => "+to.toUpperCase()+" : "+response.getRatesName(3));



    }
    private  static  void WriteToFile()
    {

    }
    private static boolean CheckConvert(String val,String [] ar)
    {
            for (int i =0 ;i < ar.length;i++)
            {
                if(val.toUpperCase().equals(ar[i]))
                    return true;
            }
            System.out.println("Wrong input: " + val);
            return false;
    }
}

