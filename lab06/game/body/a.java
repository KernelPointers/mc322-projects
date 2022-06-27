/*package game.body;

import game.body.ProvidedInterfaces.IPlayer;

public class Player extends Actor implements IPlayer{
    private boolean isLinked = false;
    private int cameraI, cameraJ;
    private BodyInterface linkedBody;
    private int nextI, nextJ;
    private int lastI, lastJ;
    private int[] linkOrientation = new int[2];

    public Player(char id, int i, int j){
        super(id, i, j);
        //this.img = new Image()
        this.readImg("assets/player/", 1);

        this.dir = 'r';
    }
    
    public void interact(){
        this.updateNextPos();

        char nextId = this.room.getId(nextI, nextJ);

        if (this.isLinked)
            this.unlink();
        else {
            switch(nextId){
                case 'b' : 
                    this.linkBox(this.room.getBody(nextI, nextJ)); break;
        }
        }
    }



    public void linkBox(BodyInterface body){
            this.isLinked = true;
            this.linkedBody = body;
            this.linkOrientation[0] = this.ori[0];
            this.linkOrientation[1] = this.ori[1];

    }

    public void unlink(){
        this.isLinked = false;
        this.linkedBody = null;
    }

    public void push(){
        if (this.room.getBody(nextI, nextJ) == this.linkedBody)
            if (this.room.canMove(this.i + 2*ori[1], this.j + 2*ori[0])){
                this.room.moveBody(this.i + 2*this.ori[1], 
                               this.j + 2*this.ori[0], 
                               this.ori);
                super.move();
            }
    }

    public void pull(){
        if (this.room.getBody(this.i - this.ori[1], this.j - this.ori[0]) == this.linkedBody){
            super.move();

            this.room.moveBody(this.i - this.ori[1], 
                            this.j - this.ori[0], 
                            this.ori);
        }
    }

    public void drag(){
        int bodyI = this.linkedBody.getI();
        int bodyJ = this.linkedBody.getJ();
        if (this.room.canMove(bodyI + this.ori[1], bodyJ + this.ori[0]) &&
                            this.room.canMove(this.nextI, this.nextJ)){

            this.room.dragBody(bodyI, bodyJ, bodyI + this.ori[1], bodyJ + this.ori[0], ori);
            super.move();
        }
        
    }

    public boolean vectorEquality(int[] v, int[] u){
        if (v[0] == u[0] && v[1] == u[1]){
            return true;
        } else 
            return false;
    }
    
    public boolean isInverseVector(int[] v, int[] u){
        if (v[0] == -u[0] && v[1] == -u[1])
            return true;
        return false;
    }

    @Override
    public void move(char dir){
        this.changeVectorOrientation(dir);

        if (this.isLinked){
            if (isInverseVector(this.ori, this.linkOrientation)) // sentidos opostos
                this.pull();
            else if(vectorEquality(this.ori, this.linkOrientation)) // sentidos iguais
                this.push();
            else // perpendiculares
                this.drag();
        }else
            super.move();

    }

    @Override
    public void changeVectorOrientation(char dir){
        super.changeVectorOrientation(dir);
        this.updateNextPos();
    }

    public void updateNextPos(){
        this.nextI = this.i + ori[1];
        this.nextJ = this.j + ori[0];

    }

    public int getPlayerScreenI(){
        return this.cameraI;
    }

    public int getPlayerScreenJ(){
        return this.cameraJ;
    }

    @Override
    public void invert(){
        super.invert();
        this.unlink();
    }

}*/
