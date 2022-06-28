package game.builder;

import game.builder.ProvidedInterfaces.BuilderInterface;
import game.graphicView.IntViewRoom;
import game.world.WorldInterface;

public class Builder implements BuilderInterface{
        private WorldInterface world;
        private IntViewRoom viewRoom;
        private int layoutNum = 4;
    
        @Override
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

            this.buildViewRoom(0); // Podemos mudar qual sala eh mostrada
                                              // no inicio

        }

        @Override
        public void buildViewRoom(int levelIndex){
                this.world.attach(levelIndex, this.viewRoom, true);
                this.viewRoom.setSubject(this.world.getRoom(levelIndex, true));
                viewRoom.build();
        }

        @Override
        public void connect(IntViewRoom viewRoom) {
           this.viewRoom = viewRoom; 
        }


}
