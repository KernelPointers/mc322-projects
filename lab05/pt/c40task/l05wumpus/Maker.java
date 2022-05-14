package pt.c40task.l05wumpus;

public class Maker {
    
    public void Mount(String cave[][], Cave world){

        for (int i = 0; i < cave.length; i++){
            for (int j = 0; j < cave[i].length; j++){

                room = cave[i][j];

                if (room.isEquals("P")){
                    Hero p = new Hero(i, j);
                    p.Connect(world);
                }

                else if (room.isEquals("B")){
                    Hole h = new Hole(i, j);
                    h.Connect(world);
                }

                else if (room.isEquals("W")){
                    Wumpus w = new Wumpus(i, j);
                    w.Connect(world);
                }

                else{
                    Gold g = new Gold();
                    g.Connect(world);
                }
            }
        }
    }

}
