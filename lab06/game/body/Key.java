package game.body;

public class Key extends Rigid {
      public Key(char id, int i, int j){
        super(id, i, j);
        this.readImg("assets/key/", 2);
        this.currentImg = this.img[0];
    }
}
