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
        double startTime = Time.getTime();
        double endTime = Time.getTime();
        double dt = 0;

        this.running = true;
        while (running){
            endTime = Time.getTime();
            dt = (endTime - startTime);
            startTime = endTime;



            this.window.setGraphics();

            System.out.println(1 / dt);

            //window.setGraphics();
            //while (dt >= 1){
                //dt--;
            //}


        }
    }

}
