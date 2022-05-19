public class Wumpus extends Obstacle{
    private boolean life = 1;

    public Wumpus(int i, int j){
        this.i  = i;
        this.j = j;
        this.id = 'W';
    }

    @Override
    public void newSec(int i, int j){
        Smell s = new Smell(i - 1, j, 'f');
        c.addComp(s, i, j);
        
    }

    public void die(){
        this.world.killWumpus(this.i, this.j);
        this.life = false;

    }

}
