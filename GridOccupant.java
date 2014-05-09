/*------------------------------------------------
A GridOccupant occupies the Grid. Dipshit.
------------------------------------------------*/

public abstract class GridOccupant
{
  private Coord coords;
  private Coord sector;
  
  public Coord getCoords() { return coords; }
  public Coord getSector() { return sector; }
  public abstract int getSize();
  
  public void goTo(int x, int y) { coords = new Coord(x,y); }
  
  //Puts the occupant into a Grid
  public void putSelfInGrid(Grid gr)
  {
    sector = gr.add(this);
  }
  
  //Returns whether a given point is within the
  //bounds of the object
  public abstract boolean isWithin(Coord input);
  
}