package pt.c40task.l05wumpus;
import java.util.Scanner;

public class Control {
    private String moves;
    private Hero player;


    public Control(String moves){
        this.moves = moves;
    }

    public void connect(Hero player){
        this.player = player;
    }
    

    public void moveControl() {
        if (this.moves.equals(""))
            moveUser();
        else
            moveFile();
    }

    public void moveFile() {
        player.setName();
        int len = this.moves.length();
        for (int i = 0; i < len && this.player.isAlive(); i++){
            char cmd = this.moves.charAt(i);
            switch (cmd) {
                case 'w' :  moveUp(); break;
                case 's' :  moveDown(); break;
                case 'd' :  moveRight(); break;
                case 'a' :  moveLeft(); break;
                case 'k' :  this.player.equip(); break;
                case 'c' :  this.player.collect(); break;
                case 'q' :  quit(); break;

            }
        }

    }

    public void setPlayerName(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose your name: ");        

        String name = scanner.nextLine();
        this.player.setName(name);

        scanner.close();

    }

    public void moveUser(){
        this.setPlayerName();
        Scanner scanner = new Scanner(System.in);
        String cmd;

        while(this.player.isAlive()){
            cmd = scanner.nextLine();       
            char cmd_char = cmd.charAt(0);
            switch (cmd_char) {
                case 'w' :  moveUp(); break;
                case 's' :  moveDown(); break;
                case 'd' :  moveRight(); break;
                case 'a' :  moveLeft(); break;
                case 'k' :  this.player.equip(); break;
                case 'c' :  this.player.collect(); break;
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
        
        // finalizar       
    }
    
}
