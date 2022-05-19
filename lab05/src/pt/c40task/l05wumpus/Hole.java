package pt.c40task.l05wumpus;

public class Hole extends Obstacle{

    public Hole(int i, int j, char id){
        super(i, j, 'B');
    }

    @Override
    public void newSec(Cave c, int i, int j){
        Wind w = new Wind(i, j, 'b');
        c.addComp(w, i, j);
        
    }

}
