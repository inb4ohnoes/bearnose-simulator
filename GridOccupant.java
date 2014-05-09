/*------------------------------------------------
A GridOccupant occupies the Grid. Dipshit.
------------------------------------------------*/

public abstract class GridOccupant
{
  private Coord coords;
  private Grid grid;
  private Coord sector;
  
  public GridOccupant()
  {
    coords = new Coord(0,0);
  }
  
  public Coord getCoords() { return coords; }
  public Grid getGrid() { return grid; }
  public Coord getSector() { return sector; }
  public abstract int getSize();
  
  public void goTo(Coord newCoord) { coords = newCoord; }
  public void goTo(int x, int y) { goTo(new Coord(x,y); }
  
  //Puts the occupant into a Grid
  public void putSelfInGrid(Grid gr)
  {
    sector = gr.add(this);
    grid = gr;
  }
  
  //Returns whether a given point is within the
  //bounds of the object
  public abstract boolean isWithin(Coord input);
  
}