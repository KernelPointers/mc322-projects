package pt.c40task.l05wumpus;

public class Cave {
    int num = 4;
    Room map[][] = new Room[num][num];


    public Cave(){

    }

    public void addComp(Components c, int i, int j){
        Room room  = this.map[i][j];
        room.items.add(c); // rever dps

    }

    public boolean canMove(int i, int j){
        if (i > -1 && i < this.num && j > -1 && j < this.num)
            return true;
        return false;
    }


}
