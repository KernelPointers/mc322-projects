package pt.c40task.l05wumpus;
import java.util.Random;

public class Hero extends Components {
    boolean hasArrow = true,
            equipedArrow = false,
            hasGold = false;

    String name;
    int score = 0;
    
    public Hero(int i, int j, String name){
        this.i = i;
        this.j = j;
        this.name = name;
    
    }

    public void kill(){

    }

    public void move(int x, int y){
        Cave w = this.world;
        if (w.canMove(x, y)){
            w.moveToRoom(this, this.i, this.j, x, y);    
            this.score -= 15;
            this.i = x;
            this.j = y;
        }        
    }

    public void die(){
        this.score -= 1000;
        
        
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

    public Shoot(Wumpus w){
        Random rand = new Random();
        this.score -= 100;
        if (rand.nextBoolean() == true){
            if (cave[i][j].)
                this.kill(w);
        } else 
            this.die();
        this.hasArrow = false;
    }

}
