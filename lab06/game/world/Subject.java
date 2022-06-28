package game.world;


import java.awt.image.BufferedImage;

import game.graphicView.IntViewRoom;

public interface Subject {
    public void attach(IntViewRoom obs);
    public void detach(IntViewRoom obs);
    public char getId(int i, int j);
    public BufferedImage getImg(int i, int j);
    public boolean getInv();
    public void notifyObserver(int i, int j, BufferedImage img, char id);
    public boolean getButtonStats(int i, int j);
    public boolean hasButton(int i, int j);
}
