package game.world;

import game.body.*;
import game.body.ProvidedInterfaces.IntBodyFactory;
import game.world.ProvidedInterfaces.IActorMovement;
import game.AbstractFactory;

public class Room implements IActorMovement{
    private int num = 15;
    private int levelNumber;
    private boolean isInverted;
    private Cell[][] cells = new Cell[num][num];

    public Room(int levelNumber){
      this.levelNumber = levelNumber;
    }

    public void build(String buildCmd){
      for (int i = 0; i < num * num; i++){
				int x = (i % num);
				int y = (i / num);

				char cellValue = buildCmd.charAt(i);
        IntBodyFactory bodyFact = AbstractFactory.createBodyFactory();
        BodyInterface body = bodyFact.create(cellValue);

        Cell c = new Cell(body);
        cells[y][x] = c;
        // rever td isso !!!!!!!!!!
        //if (cellValue != '#'){
         // if (cellValue == 'p'){
          //    IntBodyInstance bodyInst = new Body();
         //     this.connect(bodyInst);
         ///     Body player = body.bodyInstance('p');
        //  } 
        //}
			
		  }
    }

    public int getLevelNumber(){
      return this.levelNumber;
    }
    
    public boolean canMove(int i, int j){
      /* Retorna se um Actor pode se mover para uma Celula [i][j]*/
       if (i > -1 && i < this.num && j > -1 && j < this.num && !this.hasCollision(i, j))
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
    }

    public void clearActor(int i, int j){
      BodyInterface empty = AbstractFactory.createBodyFactory().create('#');
      this.cells[i][j].clearActor(empty);
    }
}
