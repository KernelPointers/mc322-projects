package game.graphicView.ProvidedInterfaces;

import java.awt.image.BufferedImage;

public interface IViewRoom {
    public void build();

    public void setInum(int i);

    public void setJnum(int j);

    public int getInum();

    public int getJnum();

    public BufferedImage getImg(int i, int j);

    public void setLevelIndex(int levelIndex);
    
}
