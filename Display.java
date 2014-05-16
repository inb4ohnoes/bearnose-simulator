import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.GraphicsEnvironment;


public class Display extends JFrame
{
  int width;
  int height;
  
  public Display(int widthIn, int heightIn)
  {
    super("bearnose-simulator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    width = widthIn;
    height = heightIn;
    
    setPreferredSize(new Dimension(width, height));
    setResizable(false);
    
    setLayout(null);
    
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.getAllFonts();
    
  }
  
  public void draw(String fileName, int x, int y)
  {
    try
    {
      BufferedImage img = ImageIO.read(new File(fileName));
      getGraphics().drawImage(img,x,y,null); 
    }
    catch (IOException ie)
    {
      System.out.print(ie);
    }
  }
  public void draw(String fileName, Coord at)
  {
      draw(fileName,at.getX(),at.getY()); 
  }
  
  public void draw(Sprite spr, int x, int y)
  {
    BufferedImage img = spr.getImage();
    getGraphics().drawImage(img,x,y,null);
  }
  public void draw(Sprite spr, Coord at)
  {
    draw(spr,at.getX(),at.getY()); 
  }
  
  public void drawText(String text)
  {
    getGraphics().setFont( new Font("Verdana", Font.PLAIN , 64) );
    if (getGraphics().getFont().equals(new Font("Verdana", Font.PLAIN , 64)))
      getGraphics().drawString("DAFUQ?",50,50);
    getGraphics().drawString(text,30,30);
  }
  
  public void clear(Graphics g)
  {
    g.fillRect(0, 0, width, height);
  }
  
}