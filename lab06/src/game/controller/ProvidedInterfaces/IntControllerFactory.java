package game.controller.ProvidedInterfaces;


public interface IntControllerFactory {
    public ControllerInterface create(char type); 

    public IKeyboard createKeyInput();
}
