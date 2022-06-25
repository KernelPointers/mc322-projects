package game.body;

import java.io.File;

import javax.imageio.ImageIO;

import game.body.ProvidedInterfaces.IPlayer;

public class Player extends Actor implements IPlayer{
    public Player(char id, int i, int j){
        super(id, i, j);
        //this.img = new Image()
        this.readImg("assets/player/", 1);
    }

}
