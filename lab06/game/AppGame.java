package game;

import game.builder.*;
import game.body.*;
import game.world.*;

public class AppGame {
    public static void main(String args[]){
       IntBuilderFactory bFactory = AbstractFactory.createBuilderFactory();
       BuilderInterface builder = bFactory.create('b');
       
       IntWorldFactory wFactory = AbstractFactory.createWorldFactory();
       WorldInterface world = wFactory.create('w');

       builder.connect(world);

       builder.buildWorld();

    }
}
