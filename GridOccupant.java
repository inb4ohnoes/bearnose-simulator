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
  public void goTo(int x, int y) { goTo(new Coord(x,y)); }
  
  public void moveBy(Coord byCoord) { coords = coords.plus(byCoord); }
  public void moveBy(int x, int y) { moveBy(new Coord(x,y)); }
  
  public void setSector(Coord input) { sector = input; }
  
  //Puts the occupant into a Grid, at certain
  //coordinates if you so desire
  public void enterGrid(Grid gr)
  {
    gr.add(this);
    grid = gr;
  }
  public void enterGrid(Grid gr, int x, int y)
  {
    goTo(x,y);
    gr.add(this);
    grid = gr;
  }
  
  //Returns whether a given point is within the
  //bounds of the object
  public abstract boolean isWithin(Coord input);
  
  public String toString()
  {
    String tempString = "" + getClass() + " at " + coords;
    return tempString.substring(6);
  }
  
}