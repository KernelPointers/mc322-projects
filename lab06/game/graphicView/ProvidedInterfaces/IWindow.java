package game.graphicView.ProvidedInterfaces;

import java.awt.Graphics;

import game.controller.ProvidedInterfaces.IKeyboard;
import game.graphicView.IntViewRoom;

public interface IWindow {
   public void render(Graphics g, int width, int height); 

   public void tick(double dt);

   public void showWindow();

   public void connect(IntViewRoom viewRoom);

   public void connectKeyInput(IKeyboard keyinput);

   public void updateCanvas();

}
