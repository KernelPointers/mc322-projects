package game.builder;

import game.builder.ProvidedInterfaces.BuilderInterface;
import game.builder.ProvidedInterfaces.IntBuilderFactory;

public class BuilderFactory implements IntBuilderFactory{
   public BuilderInterface create(char type){
        BuilderInterface builder = null;
        if (type == 'b')
            builder = new Builder();
        return builder;
   }
}
