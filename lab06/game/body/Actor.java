package game.body;

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
            room.setActor(this, i, j - 1);
            room.clearActor(i, j);
            this.j--;
        }

    }

    public void moveRight(){
        if (room.canMove(this.i, this.j + 1)){
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

    public void invert(){
        IRoom invRoom = room.getInverse();
        if (invRoom.canMove(this.i, this.j)){
            if (this.id == 'p'){
                this.room.invertTargetRoom();
             }
            invRoom.setActor(this, this.i, this.j);
            room.clearActor(i, j);


            this.room = invRoom;


        }
        // msg de aviso
    }
}
