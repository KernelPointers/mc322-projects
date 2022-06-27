package game.body;

import game.body.ProvidedInterfaces.IPlayer;
import game.body.ProvidedInterfaces.IntBodyFactory;

public class BodyFactory implements IntBodyFactory{
   public BodyInterface create(char type, int i, int j){
        BodyInterface body = null;
        switch(type){
            case 'p' : // player 
                body = new Player('p', i, j); break;
            case '#' : // empty
                body = new EmptyCell('#', i, j); break;
            case 'B' : // RigidBlock
                body = new RigidBlock('B', i, j); break;
            case 'b': // blocj
                body = new Block('b', i, j); break;
            case 'a': // button
                body = new Button('a', i, j); break;
            case 'd': // door
                body = new Door('d', i, j); break;
            case 'm' : // monolith
                body = new Monolith('m', i, j); break;
            case 'w': // wall
                body = new Wall('w', i, j); break;
            case 'k' : // key
                body = new Key('k', i, j); break;
            case 'l': // lever
                body = new Lever('l', i, j); break;
            case 'v': // void
                body = new Void('v', i, j);
        }
        return body;
   }

   public IPlayer createPlayer(int i, int j){
       IPlayer player = new Player('p', i, j);
       return player;
   }
}
