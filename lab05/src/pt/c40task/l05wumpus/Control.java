package pt.c40task.l05wumpus;
import java.util.Scanner;


public class Control {
    private String moves;
    private Hero player;
    private Gold gold;
    private char status = 'P';


    public Control(String moves){
        this.moves = moves;
    }

    public void connect(Hero player){
        this.player = player;
    }

    public void connectGold(Gold gold){
        this.gold = gold;
    }
    

    public void moveControl() {
        if (this.moves.equals(""))
            moveUser();
        else
            moveFile();
    }

    public void moveFile() {
        player.setName();
        
        player.updateCave();
        int len = this.moves.length();
        for (int i = 0; i < len && this.player.isAlive(); i++){
            char cmd = this.moves.charAt(i);
            switch (cmd) {
                case 'w' :  moveUp(); break;
                case 's' :  moveDown(); break;
                case 'd' :  moveRight(); break;
                case 'a' :  moveLeft(); break;
                case 'k' :  this.player.equip(); break; // n eh impresso no terminal
                case 'c' :  collectGold(); break; // printar na tela
                case 'q' :  quit(); break;

            }
        }

    }

    public void setPlayerName(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose your name: ");        

        String name = scanner.nextLine();
        this.player.setName(name);


    }

    public void moveUser(){
        this.setPlayerName();
        
     
        player.updateCave();// separar writeboard()

        Scanner scanner = new Scanner(System.in);

        String cmd;

        while(this.player.isAlive() && !this.player.gameStatus()){
            System.out.print("move: ");
            cmd = scanner.nextLine();                   
            char cmd_char = cmd.charAt(0);
            switch (cmd_char) {
                case 'w' :  moveUp(); break;
                case 's' :  moveDown(); break;
                case 'd' :  moveRight(); break;
                case 'a' :  moveLeft(); break;
                case 'k' :  this.player.equip(); break;
                case 'c' :  collectGold(); break;
                case 'q' :  quit(); break;
                default : System.out.println("Error: command not found");
            }

            
        }
        scanner.close();
        
    }
    

    public void moveLeft(){
       player.move(player.i, player.j - 1);
       this.player.updateCave();

    }


    public void moveRight(){
       player.move(player.i, player.j + 1);
       this.player.updateCave();

    }

    public void moveDown(){
       player.move(player.i + 1, player.j);
       this.player.updateCave();

    }

    public void moveUp(){
       player.move(player.i - 1, player.j);
       this.player.updateCave();

    }

    public void quit(){
        this.player.updateCave();
        System.out.println("Volte sempre !");
        player.setLife(false);
    }
    
    public void collectGold(){
       this.player.collect(this.gold);
    }

    public int getPlayerScore(){
        return this.player.getScore();
    }

    public void changeStatus(){
        if (!this.player.isAlive())
            this.status = 'L';
        else if (this.player.gameStatus())
            this.status = 'W';

    }

    public char getStatus(){
        return this.status;
    }
}
