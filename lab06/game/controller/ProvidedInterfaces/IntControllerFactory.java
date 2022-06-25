package game.controller.ProvidedInterfaces;

import java.awt.event.KeyListener;

public interface IntControllerFactory {
    public ControllerInterface create(char type); 

    public IKeyboard createKeyInput();
}
