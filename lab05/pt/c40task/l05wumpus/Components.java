package pt.c40task.l05wumpus;

public abstract class Components {
    int i, j;
    Cave world; 

    public void Connect(Cave world){
        this.world = world;
        world.addComp(this);
    }

}
