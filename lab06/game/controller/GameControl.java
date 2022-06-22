package game.controller;

import game.controller.ProvidedInterfaces.ControllerInterface;
import game.controller.RequiredInterfaces.RIWindow;
import game.graphicView.ProvidedInterfaces.IWindow;

import java.awt.Canvas;

public class GameControl implements RIWindow, Runnable, ControllerInterface{
    private boolean running = true;
    private Thread thread;
    private IWindow window;
    
    public void connect(IWindow window){
        this.window = window;
    }

    public void run(){
        double startTime = Time.getTime();
        double endTime = Time.getTime();
        double tickNum = 60.0;
        double ns = 1E9 /  tickNum;

        this.start();
        while (running){


            //while(dt >= 1){
            //    window.tick(dt);
            //    delta--;
            //}
            window.setGraphics();

            endTime = Time.getTime();
            double dt = endTime - startTime;
            startTime = endTime;
        }

        this.stop();
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