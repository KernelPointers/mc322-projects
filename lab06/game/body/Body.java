package game.body;

public abstract class Body implements BodyInterface{
    protected char id;
    protected int i, j;
   
    public Body(char id){
        this.id = id;
    }

    public char getId(){
        return this.id;
    }

    public void setId(char id){
        this.id = id;
    }
   
}
