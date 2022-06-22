package game.world;

import game.world.ProvidedInterfaces.IntWorldFactory;
import game.world.ProvidedInterfaces.WorldInterface;

public class WorldFactory implements IntWorldFactory{
   public WorldInterface create(char type){
        WorldInterface world = null;
        if (type == 'w')
            world = World.getInstance();
        return world;
   }
}
