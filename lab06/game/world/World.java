package game.world;

import java.util.ArrayList;

import game.world.ProvidedInterfaces.WorldInterface;

public class World implements WorldInterface{
    private  ArrayList<Node> rooms = new ArrayList<Node>();

    private static final World instance = new World();

    public static World getInstance(){
        return instance;
        
    }

    public void build(int position, String normalBuild, String invBuild){
        Room normal = new Room(position), inv = new Room(position);

        normal.build(normalBuild);
        inv.build(invBuild);

        Node node = new Node(normal, inv);
        
        this.rooms.add(node);
        
    }    
}

