import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Sprite
{
  private BufferedImage image;
  private int layer;
  
  public Sprite(String fileName)
  {
    try
    {
      image = ImageIO.read(new File(fileName));
    }
    catch(IOException ie)
    {
      System.out.println(ie);
      image = null;
    }
    layer = 0;
  }
  
  public BufferedImage getImage()
  {
    return image;
  }
  
  public int getLayer() { return layer; }
  
  public int getWidth() { return image.getWidth(); }
  public int getHeight() { return image.getHeight(); }
  
}