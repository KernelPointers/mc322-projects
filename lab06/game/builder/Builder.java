package game.builder;

import game.builder.ProvidedInterfaces.BuilderInterface;
import game.world.ProvidedInterfaces.WorldInterface;

public class Builder implements BuilderInterface{
        private WorldInterface world;
        private int layoutNum = 1;
    
        public void connect(WorldInterface world){
            this.world = world;
        }

        public void buildWorld(){
            TileReader reader = new TileReader();
            
            // usar controlador para fzr com q salas sejam instanciadas
            // apenas qnd o player entrar nelas

            for (int i = 0; i < this.layoutNum; i++){
                String buildCmdNormal = reader.getNormalCsv(i);
                String buildCmdInv = reader.getInvertedCsv(i);
                
                world.build(i, buildCmdNormal, buildCmdInv);
            }

        }

        public void buildController(){
            
        }

        public void buildGame(){
            this.buildController();
            this.buildGame();
        }
}
