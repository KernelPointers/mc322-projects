package pt.c40task.l05wumpus;
import java.util.ArrayList;

public class Room {
    ArrayList<Components> items = new ArrayList();
    private char statusID;
    private boolean hasPlayerBeen = false;

    public void addItem(Components c){
       this.items.add(c); 

       if (c.id == 'P')
           this.togglePlayerPresence();

        this.setPriority();
    }

    public void rmItem(Components c){
        this.items.remove(c);

        this.setPriority();
    }

    public void togglePlayerPresence(){
        this.hasPlayerBeen = true;
    }
    
    public char getStatusID(){
        return this.statusID;
    }

    public void setPriority(){
        char item;
        int len = items.size();
        
        if (len == 0){
            if (!this.hasPlayerBeen)
                this.statusID = '-';
            else 
                this.statusID = '#';

            return;
        }

        if (this.hasPlayerBeen){
            for (int i = 0; i < len; i++){
                item = items.get(i).id;
                if (item == 'W' || item == 'O' || item == 'B'){
                    this.statusID = item;
                    return;
                } else if (item = 'P'){
                    this.statusID = item;
                    return;
                } else if (item = 'f'){
                    this.statusID = item;
                    return;
                } else {
                    this.statusID = item;
                    return;
                }
                

            }   
        }
        this.statusID = '-'; 

    }
    
    public boolean hasWumpus(){
        if (this.statusID == 'W')
            return true;
        return false;

    }

    public boolean hasHole(){
        if (this.statusID == 'B')
            return true;
        return false;
    }

    public void delWumpus(){
        int len = this.items.size();

        for (int i = 0; i < len; i++)
            if (items.get(i).id == 'W')
                rmItem(items.get(i));
    }

    public void delPlayer(){
        int len = this.items.size();

        for (int i = 0; i < len; i++)
            if (items.get(i).id == 'P')
                rmItem(items.get(i));

    }


}

