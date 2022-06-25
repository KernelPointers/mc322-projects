package game.body.ProvidedInterfaces;

import game.body.BodyInterface;

public interface IPlayer extends BodyInterface{
    public void move(char dir);
    public void invert();
}
