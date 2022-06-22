package game.world.ProvidedInterfaces;

import game.body.BodyInterface;

public interface IActorMovement {
    public boolean canMove(int i, int j);

    public void setActor(BodyInterface actor, int i, int j);

    public void clearActor(int i, int j);
}

