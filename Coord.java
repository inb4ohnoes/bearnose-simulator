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
  
}