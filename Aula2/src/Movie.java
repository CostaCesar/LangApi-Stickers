import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie
{
    public String title;
    public String year;
    public String image;
    public String imDbRating;
    public static int count = 0;
    
    public Movie()
    {
        count++;
    }

    public void Print()
    {
        System.out.println("");
        System.out.println("\033[97;41mFilme: " + this.title);
        System.out.println("Lançamento: " + this.year);
        System.out.println("Imagem: " + this.image);
        int rating = Math.round(Float.parseFloat(this.imDbRating));
        for(int i = 0; i < rating; i++)
        {
            System.out.print("⭐");
        }
        System.out.println("\033[97;40m");
        System.out.print("=======================================");
    }
}
