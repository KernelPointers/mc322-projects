package game.body.ProvidedInterfaces;

import game.body.BodyInterface;

public interface IButton extends BodyInterface {

    boolean isPressed();

    void activate();

    void deactivate();
    
}
