package pt.c40task.l05wumpus;

public class Maker {
    
    public void mount(String caveStr[][], Cave world){
        // Constroi os componentes e conecta eles a caverna
        int dim = world.getNum(); 

        for (int i = 0; i < dim; i++){
            for (int j = 0; j < dim; j++){

                String room = caveStr[i][j];

                if (room.equals("P")){
                    Hero p = new Hero(i, j);
                    p.connect(world);
                }

                else if (room.equals("B")){
                    Hole h = new Hole(i, j);
                    h.connect(world);
                    h.setSec();
                }

                else if (room.equals("W")){
                    Wumpus w = new Wumpus(i, j);
                    w.connect(world);
                    w.setSec();
                }

                else if (room.equals("O")){
                    Gold g = new Gold();
                    g.connect(world);
                }
            }
        }



    }

}
