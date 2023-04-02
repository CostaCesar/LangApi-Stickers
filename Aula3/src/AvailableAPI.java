public enum AvailableAPI 
{
    IMDB("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ImdbParser()),
    POKEMON("https://pokeapi.glitch.me/v1/pokemon/greninja", new PokeParser()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-03-01", new NasaParser());

    private final String url;
    public String getUrl() {
        return url;
    }

    private final Parser parser;
    public Parser getParser() {
        return parser;
    }

    AvailableAPI(String url, Parser parser)
    {
        this.url = url;
        this.parser = parser;
    }
}
