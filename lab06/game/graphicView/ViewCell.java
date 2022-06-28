package game.graphicView;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ViewCell {
    private char id = '#';
    private BufferedImage img;
    private boolean hasButton;
    private boolean buttonStatus;
    private BufferedImage buttonImg;

    public void setImg(BufferedImage img, char id){
        this.img = img;
        this.id = id;
    }

    public boolean hasButton(){
        return this.hasButton;
    }

    public void setButton(boolean var){
        this.hasButton = var;
    }

    public void setBImg(){
        try {
        if (this.buttonStatus){
            this.buttonImg = ImageIO.read(new File("assets/button/0.png"));
        }else{
            this.buttonImg =  ImageIO.read(new File("assets/button/1.png"));
        }
        } catch (Exception err){

        }
    }

    public BufferedImage getBImg(){
        this.setBImg();
        return this.buttonImg;
    }

    public BufferedImage getImg(){
        return this.img;
    }

    public char getId(){
        return this.id;
    }

    public void setButtonStatus(boolean buttonStatus) {
        this.buttonStatus = buttonStatus;
    }

}
