package game.body;

import java.io.File;

import javax.imageio.ImageIO;

public class Door extends Rigid{
    public Door(char id, int i, int j){
        super(id, i, j);
        try{
            this.img = ImageIO.read(new File("assets/door_temp.jpg"));
        } catch (Exception error){

        }
    }
}
