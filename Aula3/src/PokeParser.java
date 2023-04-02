import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokeParser implements Parser
{
    public List<Image> GetElements(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            List<Image> output = mapper.readValue(json, new TypeReference<List<Image>>() {});
            return output; 
        }
        catch (Exception exep)
        { 
            System.out.println(exep.getMessage());
            return new ArrayList<Image>(0);
        }
    }
}
