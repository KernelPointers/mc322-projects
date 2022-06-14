package game.body;

public abstract class Body implements BodyInterface{
    private char id;
    
    public char getId(){
        return this.id;
    }

    public void setId(char id){
        this.id = id;
    }
   
}
