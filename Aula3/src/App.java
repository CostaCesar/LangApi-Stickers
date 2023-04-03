import java.util.List;

public class App {
    public static void main(String[] args) throws Exception
    {
        AvailableAPI use = AvailableAPI.PROGRAM_LANG;
        String data = new Client().GetData(use.getUrl());
        List<Image> content = use.getParser().GetElements(data);
        for (Image image : content)
        {
            System.out.println(image.toString());
            StickerGen.Create(image.image_url(), image.title());
        }
    }
}
 