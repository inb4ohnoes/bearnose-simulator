import java.util.*;

public class NPC extends Entity
{
  private String request;
  private String questInProgress;
  private String completed;
  
  public NPC(int diamIn)
  {
    super(diamIn);
    setSprite(new Sprite("bear_sprite.png.jpeg.tiff.png"));
    request = "O HAI CAN U PLZ GET ME 4500 BEARNOSES K THX";
    questInProgress = "PLZ GET ME DOES BEARNOSES SOON K?";
    completed = "O WOW THX";
  }
  
  public String getRequest() { return request; }
  public String getQuestInProgress() { return questInProgress; }
  public String getCompleted() { return completed; }
  
  public void step()
  {
    if (getGrid() != null)
      if ( !isWithin(new Coord(getGrid().getWidth(),getCoords().getY())) )
        moveBy(4,0);
  }
  
}