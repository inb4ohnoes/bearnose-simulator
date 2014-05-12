import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Sprite
{
  private String fileName;
  private int layer;
  
  public Sprite(String fn)
  {
    fileName = fn;
    layer = 0;
  }
  
  public BufferedImage getImage()
  {
    try
    {
      return ImageIO.read(new File(fileName));
    }
    catch (IOException ie)
    {
      System.out.println(ie);
      return null;
    }
  }
  
  public String getFileName() { return fileName; }
  public void setFileName(String input) { fileName = input; }
  
  public int getLayer() { return layer; }
  
  public int getWidth() { return getImage().getWidth(); }
  public int getHeight() { return getImage().getHeight(); }
  
}