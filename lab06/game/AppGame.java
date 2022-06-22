package game;

import game.world.ProvidedInterfaces.*;
import game.builder.ProvidedInterfaces.*;
import game.controller.ProvidedInterfaces.*;
import game.graphicView.ProvidedInterfaces.*;

import java.awt.Canvas;

public class AppGame extends Canvas{
    private static final long serialVersionUID = 1L;
    public static void main(String args[]){
       IntBuilderFactory bFactory = AbstractFactory.createBuilderFactory();
       BuilderInterface builder = bFactory.create('b');
       
       IntWorldFactory wFactory = AbstractFactory.createWorldFactory();
       WorldInterface world = wFactory.create('w');

       IntControllerFactory cFactory = AbstractFactory.createControllerFactory();
       ControllerInterface ctrl = cFactory.create('c');

       IntGraphicFactory vFactory = AbstractFactory.createViewFactory();
       ViewInterface view = vFactory.create('v');

       builder.connect(world);
       
       builder.buildWorld();

       ctrl.connect(view);
       
       ctrl.run();

        
    }

}
