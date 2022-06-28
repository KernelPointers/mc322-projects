package game.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.body.ProvidedInterfaces.IPlayer;
import game.controller.ProvidedInterfaces.IKeyboard;
import game.controller.RequiredInterfaces.RICamera;
import game.controller.RequiredInterfaces.ReqIPlayer;
import game.graphicView.ProvidedInterfaces.ICamera;

public class KeyboardInput extends KeyAdapter implements ReqIPlayer, RICamera, IKeyboard{
    private IPlayer player;
    private ICamera camera;
    private boolean running = true;
    
    public void subscribe(){
        this.player.addObs(this);
    }

    public boolean getStatus(){
        return this.running;
    }

    public void setRunning(boolean bool){
        this.running = bool;
    }


    public void keyPressed(KeyEvent event){
        int key = event.getKeyCode();
        
        if (key == KeyEvent.VK_W)
            player.move('u');
        else if (key == KeyEvent.VK_S)
            player.move('d');
        else if (key == KeyEvent.VK_A)
            player.move('l');
        else if (key == KeyEvent.VK_D)
            player.move('r');
        else if (key == KeyEvent.VK_I)
            player.invert();
        else if (key == KeyEvent.VK_E)
            player.interact();
        else if (key == KeyEvent.VK_C)
            player.collect();
        else if (key == KeyEvent.VK_RIGHT){
            this.camera.rotateCamera('r');
        }
        else if (key == KeyEvent.VK_LEFT){
            this.camera.rotateCamera('l');
        } 
    }



    @Override
    public void connect(IPlayer player) {
       this.player = player; 
       this.player.addObs(this);
    }

    public void connect(ICamera camera){
        this.camera = camera;
    }

        
}
