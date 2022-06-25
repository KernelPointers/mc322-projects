package game.body;

import java.io.File;

import javax.imageio.ImageIO;

public class Chest extends Rigid {
      public Chest(char id, int i, int j){
        super(id, i, j);
      try{
            this.img = ImageIO.read(new File("assets/chest_temp.jpg"));
        } catch (Exception error){

        }
    }
}
