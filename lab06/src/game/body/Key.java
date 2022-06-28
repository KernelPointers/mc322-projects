package game.body;

import java.awt.image.BufferedImage;

public class Key extends Rigid {
      public Key(char id, int i, int j){
        super(id, i, j);
        this.readImg("assets/key/", 1);
        this.currentImg = this.img[0];
    }

    @Override
    public BufferedImage getCurrentImage(boolean bool){
      return this.currentImg;
    }
}
