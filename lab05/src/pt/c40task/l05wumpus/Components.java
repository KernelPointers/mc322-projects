package pt.c40task.l05wumpus;

public class Components {
    protected int i, j;
    protected Cave world;
    protected char id;

    public void connect(Cave world){
        this.world = world;
        world.addComp(this, i, j);
    }

}
