package game.builder;

import game.world.*;

public class Builder implements BuilderInterface{
        private WorldInterface world;
        private int layoutNum = 1;
    
        public void connect(WorldInterface world){
            this.world = world;
        }

        public void buildWorld(){
            tileReader reader = new tileReader();
            
            // usar controlador para fzr com q salas sejam instanciadas
            // apenas qnd o player entrar nelas

            for (int i = 0; i < this.layoutNum; i++){
                String buildCmdNormal = reader.getNormalCsv(i);
                String buildCmdInv = reader.getInvertedCsv(i);
                
                world.build(i, buildCmdNormal, buildCmdInv);
            }

        }
}
