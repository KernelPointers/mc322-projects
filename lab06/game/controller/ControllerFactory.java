package game.controller;

import java.awt.event.KeyListener;

import game.controller.ProvidedInterfaces.ControllerInterface;
import game.controller.ProvidedInterfaces.IKeyboard;
import game.controller.ProvidedInterfaces.IntControllerFactory;

public class ControllerFactory implements IntControllerFactory{

    @Override
    public ControllerInterface create(char type) {
        ControllerInterface ctrl = null;
        if (type == 'c')
            ctrl = new GameControl();
        return ctrl;
    }

    @Override
    public IKeyboard createKeyInput() {
        IKeyboard key = new KeyboardInput();
        return key;
    }

}
