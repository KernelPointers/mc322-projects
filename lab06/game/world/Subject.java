package game.world;

import game.graphicView.Observer;

public interface Subject {
    public void attach(Observer obs);
    public void detach(Observer obs);

    public void notifyObserver();
}
