/*------------------------------------------------
The Coord class contains an x and y value,
along with functions such as the distance formula
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
  
}