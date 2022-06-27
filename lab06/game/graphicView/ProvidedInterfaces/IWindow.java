package game.graphicView.ProvidedInterfaces;

import java.awt.Graphics2D;

import game.controller.ProvidedInterfaces.IKeyboard;
import game.graphicView.IntViewRoom;

public interface IWindow extends ICamera{
   public void render(Graphics2D g, int width, int height); 

   public void tick(double dt);

   public void showWindow();

   public void connect(IntViewRoom viewRoom);

   public void connectKeyInput(IKeyboard keyinput);

   public void updateCanvas();

}
