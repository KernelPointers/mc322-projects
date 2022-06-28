package game.world;

public class Node {
    Room normal, inverted;

    public Node(Room normal, Room inverted){
        this.normal = normal;
        normal.setInverse(inverted);
        this.inverted = inverted;
        inverted.setInverse(normal);
        inverted.setInvertedStatus();
    }

    public Room getNormalRoom(){
        return this.normal;
    }  
    public Room getInvertedRoom(){
        return this.inverted;
    }

    public Room getRoom(boolean isNormal){
        if (isNormal)
            return this.getNormalRoom();
        return this.getInvertedRoom();
    }
}
