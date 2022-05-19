package pt.c40task.l05wumpus;
import java.util.ArrayList;

public class Room {
    ArrayList<Components> items = new ArrayList<Components>();
    private char statusID = '-';
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
            char max = items.get(0).id;
            for (int i = 0; i < len; i++){

                item = items.get(i).id;
                if (item == 'W' || item == 'O' || item == 'B'){
                    max = item;

                } else if (item == 'P'){
                    if (max != 'W' || max != 'O' || max != 'B')
                        max = item;

                } else if (item == 'f'){
                    if (max != 'W' || max != 'O' || max != 'B' || max != 'P')
                        max = item;

                } else if (item == 'b'){
                    if (max != 'W' || max != 'O' || max != 'B' || max != 'P' || max != 'f')
                        max = item;
                }
            }
            this.statusID = max;
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
