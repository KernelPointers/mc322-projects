package game.world;

import game.body.*;
import game.AbstractFactory;

public class Room {
    private int num = 15;
    private Cell[][] cells = new Cell[num][num];

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
}
