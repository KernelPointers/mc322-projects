package game.world.ProvidedInterfaces;

import game.graphicView.IntViewRoom;
import game.world.Room;

public interface IWorld {
    public void build(int position, String nomralBuild, String invBuild);

    public void attach(int levelIndex, IntViewRoom viewRoom, boolean isNormal);

    public Room getRoom(int levelIndex, boolean isNormal);
}
