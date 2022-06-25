package game.body;

public class Door extends Rigid{
    public boolean isLocked = true;

    public Door(char id, int i, int j){
        super(id, i, j);
        this.readImg("assets/door/", 1);
        
        this.isTangible = false;
    }

    public boolean isLocked(){
        return this.isLocked;
    }

    public void unlock(){
        this.isLocked = false;
        this.isTangible = false;
    }    
}
