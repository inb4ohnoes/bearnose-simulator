import java.util.*;

/*------------------------------------------------
An Entity is a type of GridOccupant that can move
and do things that it be wanting do. Some people
don't think it be like it is, but it do. Entities
have circular collision boxes, and are passed in
their diameter in their constructor
------------------------------------------------*/
public abstract class Entity extends GridOccupant
{
  private int diameter;
  private Sprite curSprite;
  
  // i see a distinct lack of bear noses
  private String direbearnose;
  
  public Entity(int diamIn)
  {
    super();
    diameter = diamIn;
  }
  
  //The method where you put all the shit that the Entity does
  public void step()
  {
    return;
  }
  
  public int getSize() { return diameter; }
  
  //Returns whether a given point is within the
  //bounds of the object
  public boolean isWithin(Coord input)
  {
    return getCoords().distanceTo(input) <= diameter/2;
  }
  
  public Sprite getSprite() { return curSprite; }
  public void setSprite(Sprite input) { curSprite = input; }
}
