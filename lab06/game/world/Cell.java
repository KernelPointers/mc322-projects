package game.world;

import game.body.BodyInterface;

public class Cell {
    char id;
    BodyInterface body;
    
    public Cell(BodyInterface body){
        this.body = body;
        this.id = this.body.getId();
    }

    public char getId(){
        return this.id;
    }

    public void setActor(BodyInterface actor){
        this.body = actor;
    }

    public void clearActor(BodyInterface empty){        
        this.body = empty;
        this.id = '#';
    }
}
