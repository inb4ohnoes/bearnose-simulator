import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Sprite
{
  private BufferedImage myImage;
  
  public Sprite(String fileName)
  {
    setImage(fileName);
  }
  
  public BufferedImage getImage()
  {
    return myImage;
  }
  
  public void setImage(String fileName)
  {
    try
    {
      myImage = ImageIO.read(new File(fileName));
    }
    catch (IOException ie)
    {
      System.out.println(ie);
    }
  }
  
}