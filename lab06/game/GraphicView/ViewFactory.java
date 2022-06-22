package game.GraphicView;

import game.GraphicView.ProvidedInterfaces.IntGraphicFactory;
import game.GraphicView.ProvidedInterfaces.ViewInterface;

public class ViewFactory implements IntGraphicFactory {

    @Override
    public ViewInterface create(char type) {
        ViewInterface view = null;
            if (type == 'v')
                view = new Window(1920, 1080, "game"); // VERIFICAR PARAMETROS DO CONSTRUTOR

            return view;
    }

    
}
