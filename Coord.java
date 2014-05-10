/*------------------------------------------------
The Coord class contains an x and y value,
along with functions such as the distance formula
and addition of points
------------------------------------------------*/
public class Coord
{
  private int x;
  private int y;
  public Coord(int xIn, int yIn)
  {
    set(xIn, yIn);
  }
  
  public int getX() { return x; }
  public int getY() { return y; }
  public int[] get()
  {
    int[] toReturn = new int[2];
    toReturn[0] = x;
    toReturn[1] = y;
    return toReturn;
  }
  
  public void setX(int xIn) { x = xIn; }
  public void setY(int yIn) { y = yIn; }
  public void set(int xIn, int yIn) { x = xIn; y = yIn; }
  
  public double distanceTo(Coord other)
  {
    double run = (double)getX() - other.getX();
    double rise = (double)getY() - other.getY();
    return Math.sqrt(Math.pow(run,2) + Math.pow(rise,2));
  }
  
  public boolean isNorthOf(Coord input){ return y < input.getY(); }
  public boolean isEastOf(Coord input){ return x > input.getX(); }
  public boolean isSouthOf(Coord input){ return y >input.getY(); }
  public boolean isWestOf(Coord input){ return x <input.getX(); }
  
  public boolean isNEOf(Coord input) { return isNorthOf(input) && isEastOf(input); }
  public boolean isSEOf(Coord input) { return isSouthOf(input) && isEastOf(input); }
  public boolean isSWOf(Coord input) { return isSouthOf(input) && isWestOf(input); }
  public boolean isNWOf(Coord input) { return isNorthOf(input) && isWestOf(input); }
  
  public boolean equals(Coord input) { return input.getX() == x && input.getY() == y; }
  public boolean equals(int xIn, int yIn) { return xIn == x && yIn == y; }
  
  public Coord plus(Coord input)
  {
    return new Coord(x + input.getX(), y + input.getY());
  }
  public Coord minus(Coord input)
  {
    return new Coord(x - input.getX(), y - input.getY());
  }
  
  public String toString()
  {
    return "(" + x + "," + y + ")";
  }
  
}