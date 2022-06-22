package game.world;

import java.util.ArrayList;

import game.body.*;
import game.body.ProvidedInterfaces.IntBodyFactory;
import game.world.ProvidedInterfaces.IActorMovement;
import game.AbstractFactory;
import game.graphicView.Observer;

public class Room implements IActorMovement, Subject{
    private int iNum = 15, jNum = 24; // geral para casos onde jNum > iNum
    private int levelNumber;
    private boolean isInverted;
    private Cell[][] cells = new Cell[iNum][jNum];

    private ArrayList<Observer> subscribers;

    public Room(int levelNumber){
      this.levelNumber = levelNumber;
    }

    public void build(String buildCmd){
      int x = 0, y = -1; 
      for (int i = 0; i < iNum * jNum; i++){
				x = (i % jNum);

        if (x == 0)
          y++;

				char cellValue = buildCmd.charAt(i);
        IntBodyFactory bodyFact = AbstractFactory.createBodyFactory();
        BodyInterface body = bodyFact.create(cellValue);

        Cell c = new Cell(body);
        cells[y][x] = c;

        // if (this.subs.size() != 0)
        // this.notify();
        // 
			
		  }
    }

    public void attach(Observer obs){
      this.subscribers.add(obs);
    }

    public void detach(Observer obs){
      this.subscribers.remove(obs);
    }

    public void notifyObserver(){
      for (Observer obs : this.subscribers) obs.update();
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
      if (cells[i][j].getId() == '#')
        return false;
      return true; 

    }

    public void setActor(BodyInterface actor, int i, int j){
      this.cells[i][j].setActor(actor);
      // this.notify();
    }

    public void clearActor(int i, int j){
      BodyInterface empty = AbstractFactory.createBodyFactory().create('#');
      this.cells[i][j].clearActor(empty);
      // this.notify();
    }
}
