package game.world;

public class WorldFactory implements IntWorldFactory{
   public WorldInterface create(char type){
        WorldInterface builder = null;
        if (type == 'w')
            builder = new World();
        return builder;
   }
}
