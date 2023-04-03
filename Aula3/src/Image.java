import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Image
(   @JsonAlias({"title", "name"})String title,
    @JsonAlias({"image", "url", "sprite", "image_url"})String image_url,
    @JsonAlias({"media_type"})String type
)
{}