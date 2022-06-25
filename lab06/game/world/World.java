package game.world;

import java.util.ArrayList;

import game.controller.ProvidedInterfaces.IKeyboard;
import game.graphicView.IntViewRoom;

public class World implements WorldInterface{
    private  ArrayList<Node> rooms = new ArrayList<Node>();

    private IKeyboard keyInput;

    private static final World instance = new World();

    public static World getInstance(){
        return instance;
        
    }

    public void build(int position, String normalBuild, String invBuild){
        Room normal = new Room(position), inv = new Room(position);

        normal.build(normalBuild, keyInput);
        inv.build(invBuild, keyInput);

        Node node = new Node(normal, inv);
        
        this.rooms.add(node);
        
    }

    @Override
    public void attach(int levelIndex, IntViewRoom viewRoom, boolean isNormal) {
        // coonsideramos que so se pode passar de fase pela sala normal
        this.getRoom(levelIndex, isNormal).attach(viewRoom);
    }    

    @Override
    public Room getRoom(int levelIndex, boolean isNormal){
        return this.rooms.get(levelIndex).getRoom(isNormal);
    }

    @Override
    public void connect(IKeyboard keyInput) {
        this.keyInput = keyInput; 
    }

    
}

