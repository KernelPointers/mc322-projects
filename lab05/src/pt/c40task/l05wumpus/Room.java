package pt.c40task.l05wumpus;
import java.util.ArrayList;

public class Room {
    private ArrayList<Components> items = new ArrayList<Components>();
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
            char max = '#';
            for (int i = 0; i < len; i++){
                item = items.get(i).id;
                if (comp(max,  item))
                    max = item;
            }
            this.statusID = max;
            return;

        }
        this.statusID = '-';

    }

    public boolean comp(char a, char b){
        if (b == 'W' || b == 'O' || b =='B')
            return true;
        if (b == 'P' && (a == 'W'  || a == 'O' ||  a == 'B'))
            return false;
        else if (b == 'P')
            return true;
        else if (b == 'f' && a == 'P')
            return false;
        else if (b == 'f')
            return true;
        else if (b == 'b' && a == 'f')
            return false;
        else if (b == 'b')
            return true;
        else if (b == '#')
            return false;
        else 
            return false;
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
            if (items.get(i).id == 'W'){
                this.rmItem(items.get(i));
                return;
            }
    }

    public void delPlayer(){
        int len = this.items.size();

        for (int i = 0; i < len; i++)
            if (items.get(i).id == 'P')
                rmItem(items.get(i));

    }

    public int sizeOfItems(){
        return this.items.size();
    }

    public char getItemId(int k){
        return this.items.get(k).id; 
    }
}
