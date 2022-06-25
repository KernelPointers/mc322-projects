package game.body;

import java.io.File;

import javax.imageio.ImageIO;

public class Wall extends Rigid{
   public Wall(char id, int i, int j){
        super(id, i, j);
        this.readImg("assets/wall/", 1); 

    } 
}
