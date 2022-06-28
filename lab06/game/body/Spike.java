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
        this.updateImg();
    }

    public void updateImg(){
        if (this.isArmed){
            this.currentImg = this.img[0];
        } else{
            this.currentImg = this.img[1];
        }
    }

    public void toogleArmed(){
        if (this.isArmed){
            this.updateImg();
            setArmedStatus(false);
        } else{
            this.updateImg();
            setArmedStatus(true);
        }
    }

    
    public void setTimer(){ // delay em ms
        Timer timer = new Timer(1000/180, new SpikeEvent(this));

        timer.start();
    }

    public void update(){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                setTimer();

            }
        });
    }



    
}
