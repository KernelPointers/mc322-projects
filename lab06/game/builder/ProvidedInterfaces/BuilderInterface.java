package game.builder.ProvidedInterfaces;

import game.builder.RequiredInterfaces.RIViewRoom;
import game.builder.RequiredInterfaces.ReqIntWorld;

public interface BuilderInterface 
    extends ReqIntWorld, RIViewRoom{

    public void buildWorld();

    public void buildViewRoom(int levelIndex);
}
