package game.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.body.ProvidedInterfaces.IPlayer;
import game.controller.ProvidedInterfaces.IKeyboard;
import game.controller.RequiredInterfaces.ReqIPlayer;

public class KeyboardInput extends KeyAdapter implements ReqIPlayer, IKeyboard{
    IPlayer player;

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
        
    }

    @Override
    public void connect(IPlayer player) {
       this.player = player; 
    }

        
}
