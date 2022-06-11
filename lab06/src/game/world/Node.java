package game.world;

public class Node {
    Room normal, inverted;

    public Node(Room normal, Room inverted){
        this.normal = normal;
        this.inverted = inverted;
    }
}
