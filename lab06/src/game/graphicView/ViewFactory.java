package game.graphicView;

import game.graphicView.ProvidedInterfaces.IWindow;
import game.graphicView.ProvidedInterfaces.IgraphicViewFactory;

public class ViewFactory implements IgraphicViewFactory {

    @Override
    public IntViewRoom createViewRoom(int iNum, int jNum, int levelIndex) {
        IntViewRoom viewRoom = new ViewRoom();
        viewRoom.setInum(iNum);
        viewRoom.setJnum(jNum);
        viewRoom.setLevelIndex(levelIndex);
        return viewRoom;
    }

    @Override
    public IWindow createWindow(int width, int height, String name) {
        IWindow window = new Window(width, height, name);
        return window;
    } 
}
