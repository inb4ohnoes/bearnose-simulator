import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import java.util.*;


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
  
  public String drawText(String text, int boxHeight)
  {
    Graphics g = getGraphics();
    Font f = new Font("Verdana", Font.PLAIN , 32);
    FontMetrics fm = new FontMetrics(f) {};
    
    g.setFont(f);
    int textHeight = fm.getHeight();
    
    ArrayList<String> lines = new ArrayList<String>();
    int curLineSize = 0;
    int beginning = 0;
    
    for(int x = 0; x < text.length(); x++)
    {
      if (curLineSize + fm.charWidth(text.charAt(x)) <  getWidth())
      {
        curLineSize += fm.charWidth(text.charAt(x));
        if (x == text.length()-1)
        {
          lines.add(text.substring(beginning,x));
        }
      }
      else
      {
        lines.add(text.substring(beginning,x));
        beginning = x;
        curLineSize = 0;
      }
    }
    
    for(int y = 0; y < boxHeight; y++)
    {
      g.drawString("" + lines.get(y), 0, getHeight() - (boxHeight - y) * fm.getHeight());
    }
    
    if(lines.size() <= boxHeight)
      return "";
    else
    {
      String toReturn = "";
      for (int z = boxHeight; z < lines.size(); z++)
        toReturn += lines.get(z);
      return toReturn;
    }
    
  }
  
  public void clear(Graphics g)
  {
    g.fillRect(0, 0, width, height);
  }
  
}