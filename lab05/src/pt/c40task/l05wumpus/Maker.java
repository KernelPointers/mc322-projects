package pt.c40task.l05wumpus;

public class Maker {
    
    public void mount(String caveStr[][], Cave world, Control ctrl){
        // Constroi os componentes e conecta eles a caverna
        int dim = world.getNum();

        int linha = 0, coluna = 0;

        for (int i = 0; i < dim*dim; i++){
            for (int j = 0; j < 3; j++){
                if (j == 2){
                    String room = caveStr[i][j];

                    if (room.equals("P")){
                        Hero p = new Hero(linha, coluna, 'P');
                        p.connect(world);                        
                        ctrl.connect(p);
                    }

                    else if (room.equals("B")){
                        Hole h = new Hole(linha, coluna, 'B');
                        h.connect(world);
                        h.setSec();
                    }

                    else if (room.equals("W")){
                        Wumpus w = new Wumpus(linha, coluna, 'W');
                        w.connect(world);
                        w.setSec();
                    }

                    else if (room.equals("O")){
                        Gold g = new Gold(linha, coluna, 'O');
                        g.connect(world);
                        ctrl.connectGold(g);
                    } 
                }                
            }
            if ((i+1) % 4 == 0) {
                linha++;
                coluna = 0;
            }
            else
                coluna++;
        }
    }

}
