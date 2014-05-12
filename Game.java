public class Game
{
  public static void main(String args[])
  {
    Display display = new Display(600,400);
    
    System.out.println("Bearnose Collector Simulator 2014!!!!!!!!!!111111");
    World aWholeNewWorld = new World(128,128);
    Entity someDude = new Entity(3);
    
    
    aWholeNewWorld.add(someDude,4,7);
    
    /*System.out.println(someDude.getGrid().isValid(someDude.getCoords().plus(new Coord (4,0))));
    System.out.println(someDude.getCoords().plus(new Coord (4,0)));
    System.out.println(someDude.getCoords().isSEOf(new Coord(0,0)));*/
    
    while(!someDude.getCoords().equals(124,7))
    {
      aWholeNewWorld.tick();
      System.out.print(aWholeNewWorld);
      display.draw("bear_sprite.png.jpeg.tiff.png", someDude.getCoords());
      display.draw("bear_sprite.png.jpeg.tiff.png", someDude.getCoords().getX(), 200);
    }
  }
}