import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception
    {
        List<Movie> list = Parser.ParseMovies(
            new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"))
            .getItems();
        
        for (Movie x : list)
        {
            x.Print();
        }
    }
}
 