package game.world;

import game.body.*;

public class Room implements ReqIntBodyInstance{
    private int num = 15;
    private Cell[][] cells = new Cell[num][num];
    private IntBodyInstance body;

    public void connect(IntBodyInstance body){
      this.body = body;
    }

    public void build(String buildCmd){
		  for (int i = 0; i < num * num; i++){
				int x = (i % num);
				int y = (i / num);

				char cellValue = buildCmd.charAt(i);

        Cell c = new Cell();
        cells[x][y] = c;

        // rever td isso !!!!!!!!!!
        if (cellValue != '#'){
          if (cellValue == 'p'){
              IntBodyInstance bodyInst = new Body();
              this.connect(bodyInst);
              Body player = body.bodyInstance('p');
          } 
        }
			
		  }
    }
}
