package game.body;

import java.awt.image.BufferedImage;

public class Spike extends Body {
    private boolean isArmed = false;
    private int spriteTimer = 12;

    public Spike(char id, int i, int j) {
        super(id, i, j);
        this.readImg("assets/spike/", 2);
        this.currentImg = this.img[1];
    }

    public boolean getArmedStatus(){
        return this.isArmed;
    }

    public void setArmedStatus(boolean isArmed){
        this.isArmed = isArmed;
    }

    @Override
    public BufferedImage getCurrentImage(boolean isInv){

        this.spriteTimer--;
        if (spriteTimer < 1){
            this.currentImg = this.img[0];
            this.room.notifyObserver(this.i, this.j, currentImg, 's');
            this.spriteTimer = 12;
            return this.currentImg;

        }

        this.currentImg = this.img[1];  
        this.room.notifyObserver(this.i, this.j, currentImg, 's');
        return this.currentImg;
    }


    
    
}
