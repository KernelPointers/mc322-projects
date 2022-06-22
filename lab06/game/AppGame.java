package game;

import game.world.ProvidedInterfaces.IntWorldFactory;
import game.world.ProvidedInterfaces.WorldInterface;
import game.GraphicView.Window;
import game.GraphicView.ProvidedInterfaces.IntGraphicFactory;
import game.GraphicView.ProvidedInterfaces.ViewInterface;
import game.builder.ProvidedInterfaces.BuilderInterface;
import game.builder.ProvidedInterfaces.IntBuilderFactory;
import game.controller.ProvidedInterfaces.ControllerInterface;
import game.controller.ProvidedInterfaces.IntControllerFactory;

import java.awt.Canvas;

public class AppGame extends Canvas{
    private static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9;

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
