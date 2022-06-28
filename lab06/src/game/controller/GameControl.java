package game.controller;

import game.controller.ProvidedInterfaces.ControllerInterface;
import game.controller.ProvidedInterfaces.IKeyboard;
import game.controller.RequiredInterfaces.RIWindow;
import game.graphicView.ProvidedInterfaces.IWindow;
import game.world.Room;
import game.world.World;

public class GameControl implements RIWindow, Runnable, ControllerInterface{
    private boolean running = true;
    private IWindow window;
    private int levelIndex;
    private boolean levelStatus;
    private World world = World.getInstance();
    private IKeyboard input;
    
    public void connect(IWindow window){
        this.window = window;
    }

    public void setInput(IKeyboard input){
        this.input = input;
    }

    @Override
    public void run(){
        int fps = 60;
        double interval = 1E9 / fps;
        double dt = 0;
        long last = System.nanoTime(); 
        long current;

        this.start();

        this.window.showWindow();

        while (running){



            current = System.nanoTime();

            dt += (current - last) / interval;

            last = current;

            if (dt >= 1){
                //this.update();  
                this.window.updateCanvas();
                  
                dt--;
            }

            this.running = input.getStatus();

        }
    }

    public void start(){
        this.running = true;
    }

    public void getLevelIndex(){
        this.levelIndex = this.window.getIndex();
    }

    public void getLevelStatus(){
        this.levelStatus = this.window.getLevelStatus();
    }

    public void updateGame(){
        this.getLevelIndex();
        this.getLevelStatus();

        int iNum = 30;
        int jNum = 48;

        Room currentRoom = this.world.getRoom(this.levelIndex, this.levelStatus);

        for (int i = 0; i < iNum; i++){
            for (int j = 0; j < jNum; j++){
                currentRoom.update(i, j);
            }
        }
    }

    public boolean getStatus() {
        return this.running;
    }

}
