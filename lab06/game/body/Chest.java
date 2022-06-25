package game.body;

public class Chest extends Rigid {
      public Chest(char id, int i, int j){
        super(id, i, j);
        this.readImg("assets/chest/", 1);
    }
}
