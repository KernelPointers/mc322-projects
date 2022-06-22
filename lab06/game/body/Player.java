package game.body;

import game.body.ProvidedInterfaces.IPlayer;

public class Player extends Actor implements IPlayer{
    public Player(char id){
        super(id);
    }

}
