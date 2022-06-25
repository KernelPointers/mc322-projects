package game.body;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import game.body.RequiredInterfaces.RIRoom;
import game.world.ProvidedInterfaces.IRoom;

public abstract class Body implements BodyInterface, RIRoom{
    protected char id;
    protected int i, j;
    protected boolean isTangible = true;
    protected BufferedImage img[];
    protected IRoom room;
   
    public Body(char id, int i, int j){
        this.id = id;
        this.i = i;
        this.j = j;
    }

    public void connect(IRoom room){
        this.room = room;
    }

    public boolean isTangible(){
        return this.isTangible;
    }

    public char getId(){
        return this.id;
    }


    public BufferedImage[] getImg(){
        return this.img;
    }

    public void readImg(String dir, int num){
        this.img = new BufferedImage[num];
        for (int k = 0; k < num; k++){
           String sprite_name = dir + k + ".png"; 
           try {
                this.img[k] = ImageIO.read(new File(sprite_name));
           } catch (Exception err){

           }
        }
    }

    public int getI(){
        return this.i;
    }

    public int getJ(){
        return this.j;
    }

    public void setI(int i){
        this.i = i;
    }

    public void setJ(int j){
        this.j = j;
    }

    public void setId(char id){
        this.id = id;
    }
   
}
