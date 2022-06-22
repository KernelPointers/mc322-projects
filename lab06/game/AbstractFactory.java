package game;

import game.body.BodyFactory;
import game.body.ProvidedInterfaces.IntBodyFactory;
import game.builder.BuilderFactory;
import game.builder.ProvidedInterfaces.IntBuilderFactory;
import game.controller.ControllerFactory;
import game.controller.ProvidedInterfaces.IntControllerFactory;
import game.graphicView.ViewFactory;
import game.graphicView.ProvidedInterfaces.IntGraphicFactory;
import game.world.WorldFactory;
import game.world.ProvidedInterfaces.IntWorldFactory;

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

    public static IntControllerFactory createControllerFactory(){
        IntControllerFactory factory = null;
        factory = new ControllerFactory();
        return factory;
    }

    public static IntGraphicFactory createViewFactory(){
        IntGraphicFactory factory = null;
        factory = new ViewFactory();
        return factory;
    }
}
