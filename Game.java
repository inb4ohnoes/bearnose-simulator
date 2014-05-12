public class Game
{
  public static void main(String args[])
  {
    Display display = new Display(600,400);
    
    System.out.println("Bearnose Collector Simulator 2014!!!!!!!!!!111111");
    World aWholeNewWorld = new World(600,400);
    aWholeNewWorld.setDisplay(display);
    
    
    aWholeNewWorld.add(new Entity(3),35,100);
    
    while(true)
    {
      aWholeNewWorld.tick();
      System.out.print(aWholeNewWorld);
    }
  }
}