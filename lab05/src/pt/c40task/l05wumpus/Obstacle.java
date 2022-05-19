public abstract class Obstacle extends Primary{

    public void setSec(){
        Cave c = this.world;
        int dim = c.getNum();

        if (j - 1 > -1)
            this.newSec(i, j - 1);
        
        if (j < dim)
            this.newSec(i, j + 1);
            
        if (i - 1 > -1)
            this.newSec(i - 1, j);

        if (i < dim)
            this.newSec(i + 1, j);
    }
    
    /*
     * instancia objetos secundarios
     */
    public abstract void newSec();

}
