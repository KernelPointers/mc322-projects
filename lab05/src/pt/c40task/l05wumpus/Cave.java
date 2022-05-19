package pt.c40task.l05wumpus;

public class Cave {
    private int num = 4;
    private Toolkit writer;
    private Room map[][] = new Room[num][num];

    public Cave(){
        for (int i = 0; i < num; i++){
            for (int j = 0; j < num; j++){
                this.map[i][j] = new Room();
            }
        }
    }

    public int getNum(){
        return this.num;
    }

    public void connectOut(Toolkit writer){
        this.writer = writer;
    }

    public void addComp(Components c, int i, int j){
        // adiciona um Component na sala i, j
        Room room  = this.map[i][j];
        room.addItem(c);
    }

    public void rmComp(Components c, int i, int j){
        // remove um Component na sala i, j
        Room room  = this.map[i][j];
        room.rmItem(c);

    }

    public boolean hasWumpusIn(int i, int j){
        Room room = this.map[i][j];

        if (room.hasWumpus())
            return true;

        return false;

    }

    public boolean hasHoleIn(int i, int j){
        Room room = this.map[i][j];

        if (room.hasHole())
            return true;

        return false;

    }

    public void killWumpus(int i, int j){
        Room room = map[i][j];
        room.delWumpus();

    }

    public void killPlayer(int i, int j){
        Room room = map[i][j];
        room.delPlayer();

    }

    public boolean canMove(int i, int j){
        if (i > -1 && i < this.num && j > -1 && j < this.num)
            return true;
        return false;

    }

    public boolean hasGold(int i, int j){
        Room room = this.map[i][j];
        int len = room.sizeOfItems();
        for (int k = 0; k < len; k++){
            if (room.getItemId(k) == 'O')
                return true;
        }
        return false;

    }

   public void moveToRoom(Hero player, int i, int j, int x, int y){
        this.addComp(player, x, y);
        // verificar se ha inimigo
        this.rmComp(player, i, j);

   }


   public void printRoomItems(int i, int j){
        Room room = this.map[i][j];
        room.printItems();
   }

    public void displayCave(String name, int a, int b, int score, boolean win, boolean life){
        for (int i = 0; i < this.num; i++){
            for(int j = 0; j < this.num; j++){
                Room room = map[i][j];
                System.out.print(room.getStatusID() + ((j < this.num - 1) ? " " : ""));
            }
            System.out.println();

        }

        System.out.println("Player: " + name);
        System.out.println("Score: " + score);
        this.printRoomItems(a, b);

        char status = 'P';
        if (!life){
            System.out.println("Voce perdeu =( ...");
            status = 'L';
        }else if (win){
            System.out.println("Voce ganhou =D !!!");
            status = 'W';
        }
       
       writer.writeBoard(this, score, status); 

        System.out.println();
    }


    

    public char getRoomChar(int i, int j){
        return this.map[i][j].getStatusID();
    }

}
