package game.body;

public class Block extends Actor{
     public Block(char id, int i, int j){
        super(id, i, j);
        this.readImg("assets/box/", 1);
    } 
}
