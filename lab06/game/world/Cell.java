package game.world;

import game.body.BodyInterface;

public class Cell {
    char id;
    BodyInterface body;
    
    public Cell(BodyInterface body){
        this.body = body;
        this.id = this.body.getId();
    }

}
