package game.body;

import javax.swing.Timer;

public class Spike extends Body {
    private boolean isArmed;

    public Spike(char id, int i, int j) {
        super(id, i, j);
        this.readImg("assets/spike/", 2);
    }

    public boolean getArmedStatus(){
        return this.isArmed;
    }

    public void setArmedStatus(boolean isArmed){
        this.isArmed = isArmed;
    }

    public void blink(int delay){ // delay em ms
    }



    
}
