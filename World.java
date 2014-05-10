import java.util.*;

public class World
{
  Grid myGrid;
  
  public World(int width, int height)
  {
    myGrid = new Grid(width, height);
  }
  
  public void tick()
  {
    for (GridOccupant occ : myGrid.getOccupants())
    {
      if (occ instanceof Entity)
      {
        ((Entity)occ).step();
        myGrid.refresh();
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