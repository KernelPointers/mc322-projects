package game.body;

import game.world.Room;
import game.world.ProvidedInterfaces.IRoom;

public abstract class Actor extends Body {

    protected int[] ori = new int[2]; // vetor de orientacao
    protected char dir;

    public Actor(char id, int i, int j){
        super(id, i, j);
    }

    public void move(char dir){
        this.dir = dir;

        if (dir == 'u'){
            ori[0] = 0;
            ori[1] = -1;
        } else if (dir == 'd'){
            ori[0] = 0;
            ori[1] = 1;
        } else if (dir == 'r'){
            ori[0] = 1;
            ori[1] = 0;
        } else if (dir == 'l'){
            ori[0] = - 1;
            ori[1] = 0;
        }

        this.moveDir();
    }

    public void moveDir(){
        int nextI = this.i + this.ori[1], 
            nextJ = this.j + this.ori[0];
        if (room.canMove(nextI, nextJ)){
            if (this.room.hasDoor(nextI, nextJ)){
                if (this.dir == 'r')
                    this.moveToNextRoom();
                else if (this.dir == 'l')
                    this.moveToLastRoom();
                return;
            }
            

            room.setActor(this, nextI, nextJ);
            room.clearActor(i, j);

            this.i += this.ori[1];
            this.j += this.ori[0];
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
