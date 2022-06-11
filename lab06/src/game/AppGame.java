package game;

import game.builder.*;
import game.body.*;
import game.world.*;

public class AppGame {
    public static void main(String args[]){
       BuilderInterface builder = new Builder();
       
       WorldInterface world = new World();
       builder.connect(world);

       builder.buildWorld();

    }
}
