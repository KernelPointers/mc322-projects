package game.body;


public class Wall extends Rigid{
   public Wall(char id, int i, int j){
        super(id, i, j);
        this.readImg("assets/wall/", 1); 
        this.currentImg = this.img[0];

    } 
}
