/*------------------------------------------------
A GridOccupant occupies the Grid. Dipshit.
------------------------------------------------*/

public abstract class GridOccupant
{
  private int x;
  private int y;
  private int[] sector;
  
  public int getX() { return x; }
  public int getY() { return y; }
  public int[] getSector() { return sector; }
  public abstract int getSize();
  
  public void setX(int setTo) { x = setTo; }
  public void setY(int setTo) { y = setTo; }
  
  //Puts the occupant into a Grid
  public void putSelfInGrid(Grid gr)
  {
    sector = gr.add(this);
  }
  
  //Returns whether a given point is within the
  //bounds of the object
  public abstract boolean isWithin(int x, int y);
  
}