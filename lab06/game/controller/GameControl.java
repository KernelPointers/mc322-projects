package game.controller;

import game.controller.ProvidedInterfaces.ControllerInterface;
import game.controller.RequiredInterfaces.RIWindow;
import game.graphicView.ProvidedInterfaces.IWindow;
import game.world.World;

public class GameControl implements RIWindow, Runnable, ControllerInterface{
    private boolean running = true;
    private IWindow window;
    private int levelIndex;
    private boolean levelStatus;
    private World world = World.getInstance();
    
    public void connect(IWindow window){
        this.window = window;
    }

    @Override
    public void run(){
        int fps = 300;
        double interval = 1E9 / fps;
        double dt = 0;
        long last = System.nanoTime(); 
        long current;

        this.window.showWindow();
        this.running = true;

        while (running){

            current = System.nanoTime();

            dt += (current - last) / interval;

            last = current;

            if (dt >= 1){
                //update
                this.window.updateCanvas();
                this.update();    
                dt--;
            }

        }
    }

    public void getLevelIndex(){
        this.levelIndex = this.window.getIndex();
    }

    public void getLevelStatus(){
        this.levelStatus = this.window.getLevelStatus();
    }

    public void update(){
        this.getLevelIndex();
        this.getLevelStatus();

        int iNum = 30;
        int jNum = 48;

        for (int i = 0; i < iNum; i++){
            for (int j = 0; j < jNum; j++){
                this.world.getRoom(this.levelIndex, this.levelStatus).update(i, j);
            }
        }
    }

}
