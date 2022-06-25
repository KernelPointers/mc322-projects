package game.world.ProvidedInterfaces;

import game.body.BodyInterface;
import game.world.Room;

public interface IRoom {
    public boolean canMove(int i, int j);

    public void setActor(BodyInterface actor, int i, int j);

    public void clearActor(int i, int j);

    public Room getInverse();

    public void invertTargetRoom();
}
