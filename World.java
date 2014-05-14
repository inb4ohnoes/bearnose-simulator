import java.util.*;
import java.awt.image.BufferedImage;

public class World
{
  Grid myGrid;
  Display drawTo;
  ScaledSprite background;
  
  //needs more bearnoses
  private int bearnose;
  
  public World(int width, int height)
  {
    myGrid = new Grid(width, height);
    drawTo = null;
    background = null;
  }
  public World(int width, int height, String bgFileName)
  {
    myGrid = new Grid(width, height);
    drawTo = null;
    background = new ScaledSprite(bgFileName, (int)width, (int)height);
  }
  
  public int getWidth() { return myGrid.getWidth(); }
  public int getHeight() { return myGrid.getHeight(); }
  
  public void setDisplay(Display display) { drawTo = display; }
  
  public void tick()
  {
    for (GridOccupant occ : myGrid.getOccupants())
    {
      if (occ instanceof Entity)
        ((Entity)occ).step();
      myGrid.refresh();
    }
    
    if (drawTo != null)
    {
      drawTo.draw(background,0,0);
      for (GridOccupant occ : myGrid.getOccupants())
      {
        Sprite toDraw = ((Entity)occ).getSprite();
        if (!(toDraw == null || drawTo == null))
        {
          BufferedImage image = toDraw.getImage();
          drawTo.draw(toDraw, occ.getCoords().getX() - image.getWidth()/2, occ.getCoords().getY() - image.getHeight()/2);
        }
      }
    }
  }
  
  public void add(GridOccupant occ)
  {
    occ.enterGrid(myGrid);
  }
  public void add(GridOccupant occ, int x, int y)
  {
    occ.enterGrid(myGrid,x,y);
  }
  
  public String toString()
  {
    String toReturn = "World(" + hashCode() + "):\n";
    for (GridOccupant occ : myGrid.getOccupants())
    {
      toReturn += "    " + occ + "\n";
    }
    return toReturn;
  }
  
}
