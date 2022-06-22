package game.body;

import game.body.ProvidedInterfaces.IntBodyFactory;

public class BodyFactory implements IntBodyFactory{
   public BodyInterface create(char type){
        BodyInterface body = null;
        switch(type){
            case 'p' : // player 
                body = new Player('p'); break;
            case '#' : // empty
                body = new EmptyCell('#'); break;
            case 'B' : // RigidBlock
                body = new RigidBlock('B'); break;
            case 'b': // blocj
                body = new Block('b'); break;
            case 'a': // button
                body = new Button('a'); break;
            case 'd': // door
                body = new Door('d'); break;
            case 'm' : // monolith
                body = new Monolith('m'); break;
            case 'w': // wall
                body = new Wall('w'); break;
            case 'k' : // key
                body = new Key('k'); break;
            case 'c' : // chest
                body = new Chest('c'); break;
            case 'l': // lever
                body = new Lever('l'); break;
        }
        return body;
   }
}
