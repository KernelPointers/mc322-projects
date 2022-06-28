package game.body;


public class RigidBlock extends Rigid {
    public RigidBlock(char id, int i, int j){
        super(id, i , j);
        this.readImg("assets/block/", 2);
        this.currentImg = this.img[0];
    }
}
