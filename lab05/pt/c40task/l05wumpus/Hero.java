package pt.c40task.l05wumpus;
import java.util.Random;

public class Hero extends Components {
    boolean hasArrow;
    String name;
    
    public Hero(int i, int j, String name){
        this.i = i;
        this.j = j;
        this.name = name;
    
    }

    public void kill(){

    }

    public void move(int x, int y){
        if (this.world.canMove(x, y)){
            this.world

        }        
    }

    public void die(){
        
        
    }

    public Equip(){

    }

    public Shoot(Wumpus w){
        Random rand = new Random();
        if (rand.nextBoolean() == true)
            if (cave[i - 1][j - 1].)
            this.kill(w);
        this.hasArrow = false;
    }

    }

