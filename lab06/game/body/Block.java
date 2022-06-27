package game.body;

public class Block extends Body{
     public Block(char id, int i, int j){
        super(id, i, j);
        this.readImg("assets/box/", 1);
        this.currentImg = this.img[0];
    } 
}
