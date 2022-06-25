package game.controller.ProvidedInterfaces;

import game.body.ProvidedInterfaces.IPlayer;

import java.awt.event.KeyListener;

public interface IKeyboard extends KeyListener{
   public void connect(IPlayer player); 
}
