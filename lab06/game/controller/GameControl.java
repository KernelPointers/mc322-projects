package game.controller;

import game.GraphicView.ProvidedInterfaces.IWindow;
import game.controller.ProvidedInterfaces.ControllerInterface;
import game.controller.RequiredInterfaces.RIWindow;

import java.awt.Canvas;

public class GameControl implements RIWindow, Runnable, ControllerInterface{
    private boolean running = true;
    private Thread thread;
    private IWindow window;
    
    public void connect(IWindow window){
        this.window = window;
    }

    public void run(){
        double startTime = Time.getStartTime();
        double endTime = Time.getTime();

        while (running){

            window.setGraphics();

            endTime = Time.getTime();
            double dt = endTime - startTime;
            startTime = endTime;
        }
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        this.running = true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            this.running = false;
        } catch (Exception error){
            error.printStackTrace();
        }
    }
}
