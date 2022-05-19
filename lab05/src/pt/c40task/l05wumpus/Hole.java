public class Hole extends Obstacle{

    public Hole(int i, int j){
        this.i = i;
        this.j = j;
        this.id = 'B';

    }

    @Override
    public void newSec(int i, int j){
        Wind w = new Wind(i, j, 'b');
        c.addComp(w, i, j);
        
    }

}
