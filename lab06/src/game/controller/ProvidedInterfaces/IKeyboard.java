package game.controller.ProvidedInterfaces;

import game.body.ProvidedInterfaces.IPlayer;
import game.graphicView.ProvidedInterfaces.ICamera;

import java.awt.event.KeyListener;

public interface IKeyboard extends KeyListener{
   public void connect(IPlayer player); 
   public void connect(ICamera camera); 
   public void setRunning(boolean bool);
   public boolean getStatus();
}
