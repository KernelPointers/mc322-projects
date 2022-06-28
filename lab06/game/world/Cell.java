package game.world;

import game.body.BodyInterface;
import game.body.ProvidedInterfaces.IButton;

import java.awt.image.BufferedImage;

public class Cell {
    private char id;
    private BodyInterface body;
    private int i, j;
    private boolean hasButton;
    private IButton button;
    
    public Cell(BodyInterface body, int i, int j){
        this.body = body;
        this.id = this.body.getId();
        this.i = i;
        this.j = j;
    }

    public void setButton(IButton button){
        this.button = button;
        this.hasButton = true;
    }

    public boolean getButtonStatus(){
        if (this.button!=null)
            return this.button.isPressed();
        return false;
    }

    public boolean hasButton(){
        return this.hasButton;
    }

    public char getId(){
        return this.id;
    }

    public BufferedImage getImg(boolean isInv){
        return this.body.getCurrentImage(isInv);
    }

    public BodyInterface getBody(){
        return this.body;
    }

    public void setActor(BodyInterface actor){
        this.body = actor;
        this.id = body.getId();
        this.testButton();
    }

    public void clearActor(BodyInterface empty){        
        if(hasButton){
            this.body = button;
            this.id = 'a';
            this.testButton();
            return;
        }
        this.body = empty;
        this.id = '#';
        this.testButton();
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


    public void testButton(){
        if (this.id != 'a' && this.hasButton){
            this.button.activate();
        } else if (this.id == 'a' && this.hasButton){
            this.button.deactivate();
        }
    }
}
