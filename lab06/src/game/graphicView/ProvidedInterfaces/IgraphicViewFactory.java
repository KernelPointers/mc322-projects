package game.graphicView.ProvidedInterfaces;

import game.graphicView.IntViewRoom;

public interface IgraphicViewFactory {
    public IntViewRoom createViewRoom(int iNum, int jNum, int levelIndex);
    public IWindow createWindow(int width, int height, String name);
}
