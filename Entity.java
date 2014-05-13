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
  private Sprite curSprite;
  
  // i see a distinct lack of bear noses
  private String direbearnose;
  
  public Entity(int diamIn)
  {
    super();
    diameter = diamIn;
    curSprite = new Sprite("bear_sprite.png.jpeg.tiff.png");
  }
  
  //The method where you put all the shit that the Entity does
  //Here is a sample for the sort of thing that you can do
  public void step()
  {
    if (getGrid() == null)
      return;
    if (getGrid().isValid(getCoords().plus(new Coord (4 + curSprite.getWidth()/2,0))))
      moveBy(4,0);
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
