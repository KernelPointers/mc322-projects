package pt.c40task.l05wumpus;

public class Maker {
    
    public void mount(String caveStr[][], Cave world, Control ctrl){
        // Constroi os componentes e conecta eles a caverna
        int dim = world.getNum();
        int p_counter = 0, b_counter = 0, w_counter = 0, o_counter = 0;
        int linha = 0, coluna = 0;

        for (int i = 0; i < dim*dim; i++){
            for (int j = 0; j < 3; j++){
                if (j == 2){
                    String room = caveStr[i][j];

                    if (room.equals("P") && p_counter < 1){
                        Hero p = new Hero(linha, coluna, 'P');
                        p.connect(world);                        
                        ctrl.connect(p);
                        p_counter++;
                    }

                    else if (room.equals("B") && b_counter < 3){
                        Hole h = new Hole(linha, coluna, 'B');
                        h.connect(world);
                        h.setSec();
                        b_counter++;
                    }

                    else if (room.equals("W") && w_counter < 1){
                        Wumpus w = new Wumpus(linha, coluna, 'W');
                        w.connect(world);
                        w.setSec();
                    }

                    else if (room.equals("O") && o_counter < 1){
                        Gold g = new Gold(linha, coluna, 'O');
                        g.connect(world);
                        ctrl.connectGold(g);
                        o_counter++;
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
