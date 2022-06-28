package game.body;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.body.ProvidedInterfaces.IButton;
import java.awt.image.BufferedImage;

public class Button extends Body implements IButton{
    private boolean activated = false;

    public Button(char id, int i, int j){
        super(id, i, j);
        this.isTangible = false;
        this.readImg("assets/button/", 2); 
    } 

    public void activate(){
        this.activated = true;
    }

    public void deactivate(){
        this.activated = false;
    }

    public boolean isPressed(){
        return this.activated;
    }

    public void setCurrImg(){

        try{
        BufferedImage buttonImg;
        if (this.activated){
            buttonImg = ImageIO.read(new File("assets/button/0.png"));
        }else{
            buttonImg =  ImageIO.read(new File("assets/button/1.png"));
        }
        this.currentImg = buttonImg;
        } catch(IOException err){}  
    }

    @Override
    public BufferedImage getCurrentImage(boolean isInv){
        this.setCurrImg();
        return this.currentImg;

    }
}
