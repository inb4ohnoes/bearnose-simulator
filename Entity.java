import java.util.*;

/*------------------------------------------------
An Entity is a type of GridOccupant that can move
and do things that it be wanting do. Some people
don't think it be like it is, but it do. Entities
have circular collision boxes, and are passed in
their diameter in their constructor
------------------------------------------------*/
public class Entity extends GridOccupant
{
  private int diameter;
  
  public Entity(int diamIn)
  {
    super();
    diameter = diamIn;
  }
  
  public int getSize() { return diameter; }
  
  public boolean isWithin(Coord input)
  {
    return getCoords().distanceTo(input) <= diameter/2;
  }
  
}