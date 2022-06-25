package game;

import game.world.WorldInterface;
import game.world.ProvidedInterfaces.*;
import game.builder.ProvidedInterfaces.*;
import game.controller.ProvidedInterfaces.*;
import game.graphicView.IntViewRoom;
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
       IKeyboard keyInput = cFactory.createKeyInput();

       IgraphicViewFactory vFactory = AbstractFactory.createViewFactory();

       IWindow window = vFactory.createWindow(1920, 1080, "Game");
       IntViewRoom viewRoom = vFactory.createViewRoom(15, 24, 0);
        
       builder.connect(world);
       builder.connect(viewRoom);


       window.connectKeyInput(keyInput);
       window.connect(viewRoom);

       world.connect(keyInput);
       builder.buildWorld();

       ctrl.connect(window);
       
       ctrl.run();

        
    }

}
