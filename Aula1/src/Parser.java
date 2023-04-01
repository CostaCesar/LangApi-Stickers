import java.net.URL;
import com.fasterxml.jackson.databind.*;

public class Parser
{
    public static Movies ParseMovies(URL receive)
    {
        ObjectMapper mapper = new ObjectMapper();
        
        try
        {
            Movies list = mapper.readValue(receive, Movies.class);
            return list;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
