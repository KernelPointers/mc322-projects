package pt.c40task.l05wumpus;

public abstract class Obstacle extends Primary{

    public Obstacle(int i, int j, char id){
        super(i, j, id);
    }

    public void setSec(){
        Cave c = this.world;
        int dim = c.getNum();

        if (j - 1 > -1)
            this.newSec(c, i, j - 1);
        
        if (j < dim-1)
            this.newSec(c, i, j + 1);
            
        if (i - 1 > -1)
            this.newSec(c, i - 1, j);

        if (i < dim-1)
            this.newSec(c, i + 1, j);
    }
    
    /*
     * instancia objetos secundarios
     */
    public abstract void newSec(Cave c, int i, int j);

}
