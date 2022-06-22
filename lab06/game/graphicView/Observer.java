package game.graphicView;

import game.world.Subject;

public interface Observer {
    public void update();
    public void setSubject(Subject sub); 
}
