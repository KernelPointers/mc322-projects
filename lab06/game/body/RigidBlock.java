package game.body;

import java.io.File;

import javax.imageio.ImageIO;

public class RigidBlock extends Rigid {
    public RigidBlock(char id, int i, int j){
        super(id, i , j);
        try{
            this.img = ImageIO.read(new File("assets/block_temp.jpg"));
        } catch (Exception error){

        }
    }
}
