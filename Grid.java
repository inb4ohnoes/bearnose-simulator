import java.util.*;

/*------------------------------------------------
A Grid is divided into mulitple square sectors with
side-lengths of sectorSize. The size of the sectors
is equal to the size of the largest object in the grid.
------------------------------------------------*/

public class Grid
{
  private Object[][] grid;
  private ArrayList<GridOccupant> allOccupants;
  
  private int width;
  private int height;
  private int sectorSize;
  
  public Grid(int wIn, int hIn)
  {
    width = wIn;
    height = hIn;
    if (width >= height)
      sectorSize = width / 8;
    else
      sectorSize = height / 8;
    
    grid = new Object[width+(sectorSize-1) / sectorSize][height+(sectorSize-1) / sectorSize];
    allOccupants = new ArrayList<GridOccupant>();
  }
  public Grid(int wIn, int hIn, int ssIn)
  {
    width = wIn;
    height = hIn;
    sectorSize = width / 8;
    
    grid = new Object[width+(sectorSize-1) / sectorSize][height+(sectorSize-1) / sectorSize];
    allOccupants = new ArrayList<GridOccupant>();
  }
  
  //Adds an occupant to the Grid
  @SuppressWarnings("unchecked")
  public int[] add(GridOccupant occ)
  {
    if (occ == null)
      throw new NullPointerException();
    
    if(occ.getSize() > sectorSize)
      resizeSectors(occ.getSize());
    
    int[] placeAt = sectorOf(occ.getX(), occ.getY());
    if (grid[placeAt[0]][placeAt[1]] == null)
      grid[placeAt[0]][placeAt[1]] = new ArrayList<GridOccupant>();
    ((ArrayList<GridOccupant>) grid[placeAt[0]][placeAt[1]]).add(occ);
    allOccupants.add(occ);
    return placeAt;
  }
  
  //Returns the coordinates of the sector in
  //which the given coordinates are found
  public int[] sectorOf(int x, int y)
  {
    int[] toReturn = new int[2];
    toReturn[0] = x / sectorSize;
    toReturn[1] = y / sectorSize;
    return toReturn;
  }
  
  //Resizes the Grid to have a new sector size
  //VERBOTEN: Does not change the dimensions of the Grid
  @SuppressWarnings("unchecked")
  private void resizeSectors(int newSectorSize)
  {
    grid = new Object[width+(newSectorSize-1) / newSectorSize][height+(newSectorSize-1) / newSectorSize];
    sectorSize = newSectorSize;
    for (GridOccupant occ : allOccupants)
    {
      int[] placeAt = sectorOf(occ.getX(), occ.getY());
      if (grid[placeAt[0]][placeAt[1]] == null)
        grid[placeAt[0]][placeAt[1]] = new ArrayList<GridOccupant>();
      ((ArrayList<GridOccupant>) grid[placeAt[0]][placeAt[1]]).add(occ);
    }
  }
  
  //Returns the occupants of a given sector of the Grid
  @SuppressWarnings("unchecked")
  public ArrayList<GridOccupant> getSector(int x, int y)
  {
    return (ArrayList<GridOccupant>)grid[x][y];
  }
  @SuppressWarnings("unchecked")
  public ArrayList<GridOccupant> getSector(int[] coords)
  {
    return (ArrayList<GridOccupant>)grid[coords[0]][coords[1]];
  }
  
}