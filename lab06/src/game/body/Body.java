package game.body;

public class Body implements BodyInterface {
    public Body bodyInstance(char type){
        Body b;
        if (type == 'p'){
            return new Player();
        }
    }
}
