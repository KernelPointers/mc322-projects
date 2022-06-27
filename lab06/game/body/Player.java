package game.body;

import game.body.ProvidedInterfaces.IPlayer;

public class Player extends Actor implements IPlayer{
    private boolean isLinked = false;
    private int cameraI, cameraJ;

    public Player(char id, int i, int j){
        super(id, i, j);
        //this.img = new Image()
        this.readImg("assets/player/", 1);

        this.dir = 'r';
    }
    
    public void interact(){
        int nextI, nextJ;
        nextI = this.i + ori[1];
        nextJ = this.j + ori[0];

        char nextId = this.room.getId(nextI, nextJ);

        switch(nextId){
            case 'b' : 
                if (!this.isLinked)
                    this.link(); break;
        }
    }



    public void link(){
        if (this.isLinked)
            this.isLinked = false;
        else
            this.isLinked = true;

    }

    public void push(int ori[]){
        if (this.room.canMove(this.i + 2*ori[1], this.j + 2*ori[0])){
            this.room.moveBody(this.i + 2*this.ori[1], 
                               this.j + 2*this.ori[0], 
                               this.ori);
        }
    }

    public void pull(int ori[]){
        if (this.room.canMove(this.i - 2*ori[1], this.j - 2*ori[0])){
            this.room.moveBody(this.i - this.ori[1], 
                               this.j - this.ori[0], 
                               this.ori);
        }
    }

    @Override
    public void move(char dir){

        if (this.isLinked){
   //         this.push(this.ori);
        }

        super.move(dir);

    }

    public int getPlayerScreenI(){
        return this.cameraI;
    }

    public int getPlayerScreenJ(){
        return this.cameraJ;
    }

}
