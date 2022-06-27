package game.world;

import game.body.BodyInterface;

import java.awt.image.BufferedImage;

public class Cell {
    char id;
    BodyInterface body;
    int i, j;
    
    public Cell(BodyInterface body, int i, int j){
        this.body = body;
        this.id = this.body.getId();
        this.i = i;
        this.j = j;
    }

    public char getId(){
        return this.id;
    }

    public BufferedImage getImg(){
        return this.body.getCurrentImage();
    }

    public BodyInterface getBody(){
        return this.body;
    }

    public void setActor(BodyInterface actor){
        this.body = actor;
        this.id = body.getId();
    }

    public void clearActor(BodyInterface empty){        
        this.body = empty;
        this.id = '#';
    }

    public boolean isTangible(){
        return this.body.isTangible();
    }

    public void setJ(int j) {
        this.body.setJ(j);
    }

    public void setI(int i){
        this.body.setI(i);
    }
}
