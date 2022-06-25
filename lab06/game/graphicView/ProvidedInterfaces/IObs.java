package game.graphicView.ProvidedInterfaces;

import java.awt.image.BufferedImage;

public interface IObs {
   public void update(int i, int j, BufferedImage img, char id); 

   public void toogleRoomStatus();
}
