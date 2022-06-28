package game.body.ProvidedInterfaces;

import game.body.BodyInterface;
import game.controller.ProvidedInterfaces.IKeyboard;

public interface IPlayer extends BodyInterface{
    public void move(char dir);
    public void invert();
    public void interact();
    public void collect();
    public void addObs(IKeyboard ctrl); 
}
