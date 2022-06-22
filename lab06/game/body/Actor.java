package game.body;

import game.world.ProvidedInterfaces.IActorMovement;
import game.body.RequiredInterfaces.ReqIRoom;

public abstract class Actor extends Body implements ReqIRoom{
    private IActorMovement room;

    public void connect(IActorMovement room){
        this.room = room;
    }

    public Actor(char id){
        super(id);
    }

    public void move(char dir){
        if (dir == 'r') // right
            this.moveRight();
        else if (dir == 'l') // left
            this.moveLeft();
        else if (dir == 'u') // up
            this.moveUp();
        else if (dir == 'd') // down
            this.moveDown();
    }

    public void moveLeft(){
        if (room.canMove(this.i, this.j - 1)){
            room.setActor(this, i, j - 1);
            room.clearActor(i, j);
        }

    }

    public void moveRight(){
        if (room.canMove(this.i, this.j + 1)){
            room.setActor(this, i, j + 1);
            room.clearActor(i, j);

        }

    }

    public void moveUp(){
        if (room.canMove(this.i - 1, this.j)){
            room.setActor(this, i - 1, j);
            room.clearActor(i, j);

        }

    }

    public void moveDown(){
        if (room.canMove(this.i + 1, this.j)){
            room.setActor(this, i + 1, j);
            room.clearActor(i, j);

        }

    }
}
