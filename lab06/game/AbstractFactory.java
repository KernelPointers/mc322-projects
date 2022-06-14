package game;

import game.body.*;
import game.builder.*;
import game.world.*;

public class AbstractFactory {
   public static IntBuilderFactory createBuilderFactory(){
        IntBuilderFactory factory = null;
        factory = new BuilderFactory();
        return factory;
   } 

   public static IntWorldFactory createWorldFactory(){
        IntWorldFactory factory = null;
        factory = new WorldFactory();
        return factory;   
    }

    public static IntBodyFactory createBodyFactory(){
        IntBodyFactory factory = null;
        factory = new BodyFactory();
        return factory;

    }
}
