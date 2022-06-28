package game.body;

import game.body.ProvidedInterfaces.IntBodyProperties;
import game.world.ProvidedInterfaces.IRoom;

public interface BodyInterface extends IntBodyProperties {
    public void connect(IRoom room);
    public boolean isTangible();
    public void update();
    public void interact(boolean bool);
}
