import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class ScaledSprite extends Sprite
{
  double wScale;
  double hScale;
  
  public ScaledSprite(String fn)
  {
    super(fn);
    wScale = 1.0;
    hScale = 1.0;
  }
  public ScaledSprite(String fn, int width, int height)
  {
    super(fn);
    wScale = (double)width / super.getImage().getWidth();
    hScale = (double)height / super.getImage().getHeight();
  }
  public ScaledSprite(String fn, double ws, double hs)
  {
    super(fn);
    wScale = ws;
    hScale = hs;
  }
  
  public BufferedImage getImage()
  {
    BufferedImage base = super.getImage();
    int scaledWidth = (int)(base.getWidth()*wScale);
    int scaledHeight = (int)(base.getHeight()*hScale);
    int imageType = true ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
    
    BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
    
    Graphics2D g = scaledBI.createGraphics();
    
    g.setComposite(AlphaComposite.Src);
    g.drawImage(base, 0, 0, scaledWidth, scaledHeight, null); 
    g.dispose();
    
    return scaledBI;
  }
  
  public int getWidth() { return (int)(super.getImage().getWidth() * wScale); }
  public int getHeight() { return (int)(super.getImage().getHeight() * hScale); }
  
}