import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Display extends JFrame
{
  JFrame frame;
  
  public Display(int width, int height)
  {
    super("bearnose-simulator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setPreferredSize(new Dimension(width, height));
    //setResizable(false);
    
    setLayout(null);
    
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
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
      System.out.print("din work");
    }
  }
  
}