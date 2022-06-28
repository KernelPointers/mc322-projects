package game.body;

import java.awt.image.BufferedImage;

public class Door extends Rigid{
    private boolean isLocked = true;
    private boolean linkedToNextRoom; 
    private boolean needButon = false;

    public Door(char id, int i, int j){
        super(id, i, j);
        this.readImg("assets/door/", 2);
        this.currentImg = this.img[0];
        
        this.isTangible = true;
    }

    public boolean isLocked(){
        return this.isLocked;
    }


    @Override
    public void interact(boolean bool){
        if (bool)
            this.unlock();
        this.open();
    }

    public void buttonPressed(){
        if (this.room.getButton())
            this.needButon = true;
        else 
            this.needButon = false;
    }

    public void open(){
        if (!this.isLocked && this.room.getButton()){
            this.isTangible = false;
            this.currentImg = img[1];
            this.room.notifyObserver(this.i, this.j, currentImg, id);
        }
      
    }

    public void unlock(){
        this.isLocked = false;
        
    }    

    public boolean getNextRoomLink(){
        return this.linkedToNextRoom;
    }

    @Override
    public BufferedImage getCurrentImage(boolean bool){
        return this.currentImg;
    }
}
