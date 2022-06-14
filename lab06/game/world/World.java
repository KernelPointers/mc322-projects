package game.world;

import java.util.ArrayList;

public class World implements WorldInterface{
    private  ArrayList<Node> rooms = new ArrayList<Node>();

    public void build(int position, String normalBuild, String invBuild){
        Room normal = new Room(); 
        Room inv = new Room();

        normal.build(normalBuild);
        inv.build(invBuild);

        Node node = new Node(normal, inv);
        
        this.rooms.add(node);
        
    }    



}

