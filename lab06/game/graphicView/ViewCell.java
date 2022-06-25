package game.graphicView;

import java.awt.image.BufferedImage;

public class ViewCell {
    char id = '#';
    BufferedImage img;

    public void setImg(BufferedImage img, char id){
        this.img = img;
        this.id = id;
    }

    public BufferedImage getImg(){
        return this.img;
    }

    public char getId(){
        return this.id;
    }

}
