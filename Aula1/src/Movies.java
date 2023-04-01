import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "errorMessage" })
public class Movies {
    private List<Movie> items;

    public List<Movie> getItems() {
        return items;
    }

    public void setItems(List<Movie> movies) {
        this.items = movies;
    }
}
