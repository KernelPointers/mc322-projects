package game.world.ProvidedInterfaces;

import game.body.BodyInterface;
import game.world.Room;

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
}
