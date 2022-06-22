package game.graphicView;

import game.graphicView.ProvidedInterfaces.IntGraphicFactory;
import game.graphicView.ProvidedInterfaces.ViewInterface;

public class ViewFactory implements IntGraphicFactory {

    @Override
    public ViewInterface create(char type) {
        ViewInterface view = null;
            if (type == 'v')
                view = new Window(1920, 1080, "game"); // VERIFICAR PARAMETROS DO CONSTRUTOR
            if (type == 'r')
                view = new ViewRoom(15, 25);
            return view;
    }

    
}
