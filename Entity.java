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
  
  //The method where you put all the shit that the Entity does
  //Here is a sample for the sort of thing that you can do
  public void step()
  {
    if (getGrid() == null)
      return;
    if (getGrid().isValid(getCoords().plus(new Coord (4,0))))
      moveBy(4,0);
  }
  
  public int getSize() { return diameter; }
  
  //Returns whether a given point is within the
  //bounds of the object
  public boolean isWithin(Coord input)
  {
    return getCoords().distanceTo(input) <= diameter/2;
  }
  
}