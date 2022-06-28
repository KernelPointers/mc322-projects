package game.world;

import java.util.ArrayList;
import java.awt.image.BufferedImage;

import game.body.*;
import game.body.ProvidedInterfaces.IButton;
import game.body.ProvidedInterfaces.IPlayer;
import game.body.ProvidedInterfaces.IntBodyFactory;
import game.controller.ProvidedInterfaces.IKeyboard;
import game.world.ProvidedInterfaces.IRoom;
import game.AbstractFactory;
import game.graphicView.IntViewRoom;

public class Room implements IRoom, Subject{
    private int iNum = 30, jNum = 48; // geral para casos onde jNum > iNum
    private int levelNumber;
    private boolean isInverted = false;
    private Cell[][] cells = new Cell[iNum][jNum];
    private ArrayList<IntViewRoom> subscribers = new ArrayList<IntViewRoom>();
    private Room invertedRoom;
    private World world = World.getInstance();

    public Room(int levelNumber){
      this.levelNumber = levelNumber;
    }

    public void build(String buildCmd, IKeyboard keyInput){
      int x = 0, y = -1; 
      for (int i = 0; i < iNum * jNum; i++){
				x = (i % jNum);

        if (x == 0)
          y++;

				char cellValue = buildCmd.charAt(i);
        IntBodyFactory bodyFact = AbstractFactory.createBodyFactory();

        

        if (cellValue == 'p'){
            IPlayer body = bodyFact.createPlayer(y, x);
            body.connect(this);
            this.setKeyInput(body , keyInput); 
            Cell c = new Cell(body, y, x);
            cells[y][x] = c;
        } else if (cellValue == 'a'){
            IButton body = bodyFact.createButton(y, x);
            body.connect(this);
            Cell c = new Cell(body, y, x);
            c.setButton(body);
            cells[y][x] = c;
        } else {
            BodyInterface body = bodyFact.create(cellValue, y, x);
            body.connect(this);
            Cell c = new Cell(body, y, x);
            cells[y][x] = c;
        }

       
		  }
    }

    public void setInverse(Room invertedRoom){
      this.invertedRoom = invertedRoom;
    }

    public void setInvertedStatus(){
      this.isInverted = true;
    }

    public void attach(IntViewRoom obs){
      this.subscribers.add(obs);
    }

    public void detach(IntViewRoom obs){
      this.subscribers.remove(obs);
    }

    public boolean getButtonStats(int i, int j){
      return this.cells[i][j].getButtonStatus();
    }

    public void changeTargetRoom(Room room){
        IntViewRoom obs = this.subscribers.get(0);
        obs.toogleRoomStatus();
        obs.setSubject(room);
        obs.build();
        this.detach(obs);
        room.attach(obs);
      }
    

    public void notifyObserver(int i, int j, BufferedImage img, char id){
      for (IntViewRoom obs : this.subscribers) 
        obs.update(i, j, img, id);
    }

    public int getLevelNumber(){
      return this.levelNumber;
    }
    
    public boolean canMove(int i, int j){
      /* Retorna se um Actor pode se mover para uma Celula [i][j]*/
       if (i > -1 && i < this.iNum && j > -1 && j < this.jNum && !this.hasCollision(i, j))
           return true;
       return false;

    } 

    public boolean hasCollision(int i, int j){
      if (!cells[i][j].isTangible())
        return false;
      return true; 

    }

    public void setActor(BodyInterface actor, int i, int j){
      this.cells[i][j].setActor(actor);
      this.notifyObserver(i, j, actor.getCurrentImage(this.isInverted), actor.getId());
    }

    public void clearActor(int i, int j){
      BodyInterface empty = AbstractFactory.createBodyFactory().create('#', i, j);
      this.cells[i][j].clearActor(empty);
      this.notifyObserver(i, j, null, '#');
    
    }

    @Override
    public char getId(int i, int j) {
        return this.cells[i][j].getId();
    }

    public boolean hasDoor(int i, int j){
      if (this.getId(i, j) == 'd')
        return true;
      return false;
    }

    public boolean hasButton(int i, int j){
      if (this.cells[i][j].hasButton())
        return true;
      return false;
    }

    @Override
    public BufferedImage getImg(int i, int j) {
      return this.cells[i][j].getImg(this.isInverted);
    }

    public void setKeyInput(IPlayer player, IKeyboard keyInput){
      keyInput.connect(player);
    }

    @Override
    public Room getInverse() {
      return this.invertedRoom;
    }

    public Room getNextRoom(){
      return this.world.getRoom(this.levelNumber + 1, true);
    }

    public Room getLastRoom(){
      return this.world.getRoom(this.levelNumber - 1, true);
    }

    public void moveBody(int i, int j, int[] ori){
      if (this.canMove(i, j)){
        int oldI = i - ori[1], oldJ = j - ori[0];
        this.setActor(this.cells[oldI][oldJ].getBody(), i, j);
        this.clearActor(i - ori[1], j - ori[0]);
        this.cells[i][j].setI(i);
        this.cells[i][j].setJ(j);
      }
    }

    public void dragBody(int oldI, int oldJ, int i, int j, int[] ori){
        this.setActor(this.cells[oldI][oldJ].getBody(), i, j);
        this.clearActor(oldI, oldJ);
        this.cells[i][j].setI(i);
        this.cells[i][j].setJ(j);

    }

    public BodyInterface getBody(int i, int j){
      return this.cells[i][j].getBody();
    }

    @Override
    public boolean getInv() {
        return this.isInverted;
      
    }
 
}
