package game.body;

import game.body.ProvidedInterfaces.IPlayer;
import game.world.Room;
import game.world.ProvidedInterfaces.IRoom;

import java.awt.image.BufferedImage;

public class Player extends Body implements IPlayer {
    private boolean isLinked = false;
    private boolean isInventoryFull = false;
    private int cameraI, cameraJ;
    private BodyInterface linkedBody;
    private int nextI, nextJ;
    private int[] linkOrientation = new int[2];
    private int spriteIndex, offset = 0;
    private BodyInterface collectedItem;
    private int[] ori = new int[2]; // vetor de orientacao
    private char dir;
    private boolean invertColors = false;
    private BufferedImage[] invertedImg = new BufferedImage[4];

    public Player(char id, int i, int j){
        super(id, i, j);
        //this.img = new Image()
        this.readImg("assets/player/", 8);
        this.dir = 'r';
        this.currentImg = img[0];
    }

    @Override
    public void invertImg(){
        // 0, 1 ,2, 3
        this.spriteIndex = (this.spriteIndex + 4) % 8;
        this.currentImg = this.img[spriteIndex];
    }

    @Override
    public BufferedImage getCurrentImage(boolean isInv){
        if (isInv)
            this.invertImg();
        return this.currentImg;
    }

    public int toogleOffset(){
        if (offset == 4){
            this.offset = 0;
        } else
            this.offset = 4;
        return this.offset;
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

    public void changeVectorOrientation(char dir){
        this.dir = dir;

        if (dir == 'u'){
            ori[0] = 0;
            ori[1] = -1;
            this.spriteIndex = (!this.invertColors ? 3 : 7);
        } else if (dir == 'd'){
            ori[0] = 0;
            ori[1] = 1;
            this.spriteIndex = (!this.invertColors ? 2 : 6);
        } else if (dir == 'r'){
            ori[0] = 1;
            ori[1] = 0;
            this.spriteIndex = (!this.invertColors ? 0 : 4);
        } else if (dir == 'l'){
            ori[0] = - 1;
            ori[1] = 0;
            this.spriteIndex = (!this.invertColors ? 1 : 5);
        } 

        

        this.currentImg = img[spriteIndex];

        this.room.notifyObserver(this.i, this.j, this.currentImg, 'p');
        this.updateNextPos();
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
        if (this.room.getInv())
            this.invertColors = true; 
        IRoom invRoom = room.getInverse();
        this.invertImg();
        if (invRoom.canMove(this.i, this.j)){
            this.changeRoom(this.room.getInverse(), this.i, this.j);
        }
        // msg de aviso
        this.unlink();
    }
    
    public void moveToNextRoom(){
        this.changeRoom(this.room.getNextRoom(), 7, 1);
    }

    public void moveToLastRoom(){
        this.changeRoom(this.room.getLastRoom(), 7, 22);
    }

     public void interact(){
        this.updateNextPos();

        char nextId = this.room.getId(nextI, nextJ);

        if (this.isLinked)
            this.unlink();
        else {
            switch(nextId){
                case 'b' : 
                    this.linkBody(this.room.getBody(nextI, nextJ)); break;
                case 'k' :
                    this.linkBody(this.room.getBody(nextI, nextJ)); break;
        }
        }
    }

    public void collect(){
        
        this.updateNextPos();

        char nextId = this.room.getId(nextI, nextJ);

        if (this.isInventoryFull)
            this.drop();
        else {
            switch(nextId){
                case 'k' : 
                    this.collectBody(this.room.getBody(nextI, nextJ)); break;
        }
        }
    }

    public void drop(){
        if (this.room.canMove(nextI, nextJ)){
            this.room.setActor(this.collectedItem, nextI, nextJ);
            this.isInventoryFull = false;
        }
    }

    public void collectBody(BodyInterface body){
       this.collectedItem = body; 
       this.isInventoryFull = true;
       this.room.clearActor(nextI, nextJ);
    }

    public void linkBody(BodyInterface body){
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
                this.moveDir();
            }
    }

    public void pull(){
        if (this.room.getBody(this.i - this.ori[1], this.j - this.ori[0]) == this.linkedBody){
            this.moveDir();

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
            this.moveDir();
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
            this.moveDir();

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



}
