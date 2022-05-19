package pt.c40task.l05wumpus;
import java.util.Random;

public class Hero extends Primary {
    private boolean hasArrow = true,
            equipedArrow = false,
            hasGold = false,
            life = true;

    private String name;
    private int score = 0;
    
    public Hero(int i, int j){
        super(i, j, 'P');
    
    }

    public void setName(String name){
        this.name = name;
    }

    public void kill(){
        this.score += 500;
        this.world.killWumpus(this.i, this.j);

    }

    public void move(int x, int y){
        Cave w = this.world;
        if (w.canMove(x, y)){ 
            w.moveToRoom(this, this.i, this.j, x, y);    
            this.score -= 15; // assumimos que movimentos ilegais n descontam pts
            this.i = x;
            this.j = y;

            if (this.equipedArrow)
                this.shoot();
            else if (this.world.hasWumpusIn(x, y) || this.world.hasHoleIn(x, y))
                this.die();
        }        
    }

    public void die(){
        this.score -= 1000;
        this.life = false;

        this.world.killPlayer(this.i, this.j);
        
    }

    public void setLife(boolean val){
        this.life = val;
    }

    public void equip(){
        if (this.hasArrow)
            this.equipedArrow = true;

    } 

    public void collect(){
       if (this.world.hasGold){
           this.hasGold = true;

       }
    }

    public void shoot(){
        // preve uma flecha equipada
        Random rand = new Random();
        this.score -= 100;

        if (this.world.hasWumpusIn(this.i, this.j)){

            if (rand.nextBoolean())
                this.kill();
            else  
                this.die();

        }

        this.equipedArrow = false;
        this.hasArrow = false;
    }


    public boolean gameStatus(){
        if (this.i == 0 && this.j == 0 && this.hasGold){
            this.score += 1000;
            return true;
        }
        return false;

    }

    public boolean isAlive(){
        if (this.life)
            return true;
        return false;
    }

    public void updateCave(){
        this.world.displayCave(this.name, this.score, this.gameStatus(), this.life);
    }


}
