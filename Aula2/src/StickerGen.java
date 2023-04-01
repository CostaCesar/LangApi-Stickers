import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

public class StickerGen
{
    public static void Create(String url, String title) throws Exception
    {
        // Ler a imagem original de uma URL
        InputStream input = new URL(url).openStream();
        BufferedImage img = ImageIO.read(input);

        // Criar uma nova imagem em branco
        int width = img.getWidth();
        int height = img.getHeight();
        int height_new = height + (int)Math.round(height * 0.10);
        BufferedImage sticker = new BufferedImage(width, height_new, BufferedImage.TRANSLUCENT);

        // Passar imagem original para a nova imagem
        Graphics2D pixels = (Graphics2D) sticker.getGraphics();

        // Configurar o editor
        Font font = new Font(Font.MONOSPACED, Font.BOLD, (int)Math.round(width / title.length() * 1.56));
        pixels.setFont(font);
        pixels.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pixels.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        // Preparar o outline
        FontRenderContext context = pixels.getFontRenderContext();
        TextLayout layout = new TextLayout(title, font, context);
        AffineTransform transform = new AffineTransform();
        java.awt.Shape outline = layout.getOutline(null);
        transform = pixels.getTransform();
        transform.translate((int)Math.round(width / 16), height_new - (int)Math.round(height_new * 0.025));

        // Fazer alterações
        pixels.drawImage(img, 0, 0, null);
        pixels.setColor(Color.RED);
        pixels.drawString(title, (int)Math.round(width / 16), height_new - (int)Math.round(height_new * 0.025));
        pixels.transform(transform);
        pixels.setColor(Color.BLUE);
        pixels.draw(outline);
        pixels.setClip(outline);

        // Escrever no arquivo
        System.out.println("Image Created!");
        ImageIO.write(sticker, "png", new File("stickers/" + title.replace(":", "-") + ".png"));
    }
}
