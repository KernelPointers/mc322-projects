package game.body;

import game.world.Room;
import game.world.ProvidedInterfaces.IRoom;

public abstract class Actor extends Body {

    public Actor(char id, int i, int j){
        super(id, i, j);
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
            if (this.room.hasDoor(i, j - 1)){
                this.moveToLastRoom();
                return;
            }
            room.setActor(this, i, j - 1);
            room.clearActor(i, j);
            this.j--;
        }

    }

    public void moveRight(){
        if (room.canMove(this.i, this.j + 1)){
            if (this.room.hasDoor(i, j + 1)){
                this.moveToNextRoom();
                return;
            }
            room.setActor(this, i, j + 1);
            room.clearActor(i, j);
            this.j++;
        }

    }

    public void moveUp(){
        if (room.canMove(this.i - 1, this.j)){
            room.setActor(this, i - 1, j);

            room.clearActor(i, j);
            this.i--;

        }

    }

    public void moveDown(){
        if (room.canMove(this.i + 1, this.j)){
            room.setActor(this, i + 1, j);
            room.clearActor(i, j);
            this.i++;
        }

    }

    public void moveToRoom(Room targetRoom, int i, int j){
            targetRoom.setActor(this, i, j);
            this.room.clearActor(this.i, this.j);
            this.i = i;
            this.j = j;
            this.room = targetRoom;
    }

    public void changeRoom(Room targetRoom, int i, int j){
            if (this.id == 'p'){
                this.room.changeTargetRoom(targetRoom);
            }
           this.moveToRoom(targetRoom, i, j); 
    }

    public void invert(){
        IRoom invRoom = room.getInverse();
        if (invRoom.canMove(this.i, this.j)){
            this.changeRoom(this.room.getInverse(), this.i, this.j);
        }
        // msg de aviso
    }
    
    public void moveToNextRoom(){
        this.changeRoom(this.room.getNextRoom(), 7, 1);
    }

    public void moveToLastRoom(){
        this.changeRoom(this.room.getLastRoom(), 7, 22);
    }
}
