package game.controller;

import game.controller.ProvidedInterfaces.ControllerInterface;
import game.controller.RequiredInterfaces.RIWindow;
import game.graphicView.ProvidedInterfaces.IWindow;

public class GameControl implements RIWindow, Runnable, ControllerInterface{
    private boolean running = true;
    private IWindow window;
    
    public void connect(IWindow window){
        this.window = window;
    }

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
                dt--;
            }

        }
    }

    public void start(){
    }

    public void stop(){

    }

}
