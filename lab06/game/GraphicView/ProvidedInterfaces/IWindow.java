package game.GraphicView.ProvidedInterfaces;

import java.awt.Graphics;

public interface IWindow {
   public void render(Graphics g); 

   public void tick(double dt);

   public void setGraphics();
}
