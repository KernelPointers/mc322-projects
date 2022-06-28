package game.body;

public class Hole extends Body {

      public Hole(char id, int i, int j) {
        super(id, i, j);
        this.readImg("assets/hole/", 2);
        this.currentImg = this.img[0];
        this.isTangible = false;
    }
}
