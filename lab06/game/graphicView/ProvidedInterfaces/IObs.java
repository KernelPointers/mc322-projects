package game.graphicView.ProvidedInterfaces;

import java.awt.image.BufferedImage;

public interface IObs {
   public void update(int i, int j, BufferedImage img, char id); 

   public void toogleRoomStatus();

   public char getId(int i, int j);

   public boolean isInv();

   public boolean hasButton(int i, int j);


   public BufferedImage getButtonImg(int i, int j);


   public void setButtonStats(boolean bool, int i, int j);
   public boolean getButtonStats(int i, int j);
}
