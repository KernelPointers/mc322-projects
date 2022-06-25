package game.world;


import java.awt.image.BufferedImage;

import game.graphicView.IntViewRoom;

public interface Subject {
    public void attach(IntViewRoom obs);
    public void detach(IntViewRoom obs);
    public char getId(int i, int j);
    public BufferedImage getImg(int i, int j);

    public void notifyObserver(int i, int j, BufferedImage img, char id);
}
