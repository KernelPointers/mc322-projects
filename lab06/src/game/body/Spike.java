package game.body;


public class Spike extends Body {

    public Spike(char id, int i, int j) {
        super(id, i, j);
        this.readImg("assets/spike/", 2);
        this.currentImg = this.img[0];
        this.isTangible = false;
    }

    
}
