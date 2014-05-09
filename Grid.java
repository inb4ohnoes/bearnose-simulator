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
  public Coord add(GridOccupant occ)
  {
    if (occ == null)
      throw new NullPointerException();
    
    if(occ.getSize() > sectorSize)
      resizeSectors(occ.getSize());
    
    int[] placeAt = sectorOf(occ.getCoords()).get();
    if (grid[placeAt[0]][placeAt[1]] == null)
      grid[placeAt[0]][placeAt[1]] = new ArrayList<GridOccupant>();
    ((ArrayList<GridOccupant>) grid[placeAt[0]][placeAt[1]]).add(occ);
    allOccupants.add(occ);
    return sectorOf(occ.getCoords());
  }
  
  //Returns the coordinates of the sector in
  //which the given coordinates are found
  public Coord sectorOf(Coord input)
  {
    return new Coord(input.getX() / sectorSize, input.getY() / sectorSize);
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
      int[] placeAt = sectorOf(occ.getCoords()).get();
    if (grid[placeAt[0]][placeAt[1]] == null)
      grid[placeAt[0]][placeAt[1]] = new ArrayList<GridOccupant>();
    ((ArrayList<GridOccupant>) grid[placeAt[0]][placeAt[1]]).add(occ);
    }
  }
  
  //Refreshes the Grid so that if any occupants have moved,
  //they will be placed in the proper sectors
  public void refresh()
  {
    resizeSectors(sectorSize);
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