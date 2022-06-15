package game.world;

public class WorldFactory implements IntWorldFactory{
   public WorldInterface create(char type){
        WorldInterface world = null;
        if (type == 'w')
            world = World.getInstance();
        return world;
   }
}
