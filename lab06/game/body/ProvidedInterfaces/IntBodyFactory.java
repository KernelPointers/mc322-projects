package game.body.ProvidedInterfaces;

import game.body.BodyInterface;

public interface IntBodyFactory {
   public BodyInterface create(char type, int i, int j); 

   public IPlayer createPlayer(int i, int j);
}
