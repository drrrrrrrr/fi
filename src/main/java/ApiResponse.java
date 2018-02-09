import java.util.List;

public class ApiResponse
{
    private String base;
    private List<RateObject> rates;
    public  String getBase()
    {
        return  base;
    }

    public String getRatesName(int i)
    {
        return rates.get(i).getName();
    }

    public List<RateObject> getRates() {
        return rates;
    }
}