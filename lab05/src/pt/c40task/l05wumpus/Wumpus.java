package pt.c40task.l05wumpus;

public class Wumpus extends Obstacle{

    public Wumpus(int i, int j, char id){
        super(i, j, 'W');
    }

    @Override
    public void newSec(Cave c, int i, int j){
        Smell s = new Smell(i - 1, j, 'f');
        c.addComp(s, i, j);
        
    }

    public void die(){
        this.world.killWumpus(this.i, this.j);
    }

}
