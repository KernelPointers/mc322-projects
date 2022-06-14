package game.body;

public class BodyFactory implements IntBodyFactory{
   public BodyInterface create(char type){
        BodyInterface body = null;
        if (type == 'p')
            body = new Player();
        else if (type == '#')
            body = new EmptyCell();
        return body;
   }
}
