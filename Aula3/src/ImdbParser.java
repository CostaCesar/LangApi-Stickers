import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ImdbParser implements Parser
{
    public List<Image> GetElements(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            return mapper.readValue(json, ImageCollection.class).items;
        }
        catch (Exception exep)
        { 
            System.out.println(exep.getMessage());
            return new ArrayList<Image>(0);
        }
    }
}
