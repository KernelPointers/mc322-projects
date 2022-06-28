package game.world.ProvidedInterfaces;

import game.body.BodyInterface;
import game.world.Room;

import java.awt.image.BufferedImage;

public interface IRoom {
    public boolean canMove(int i, int j);

    public void setActor(BodyInterface actor, int i, int j);

    public void clearActor(int i, int j);

    public Room getInverse();

    public void changeTargetRoom(Room newTarget);

    public Room getNextRoom();

    public Room getLastRoom();

    public char getId(int i, int j);

    public boolean hasDoor(int i, int j);

    public void moveBody(int i, int j, int[] ori);

    public void dragBody(int oldI, int oldJ, int i, int j, int[] ori);

    public BodyInterface getBody(int i, int j);

    public void notifyObserver(int i, int j, BufferedImage img, char id);

    public boolean getInv();
}
