package pt.c40task.l05wumpus;
import java.util.Scanner;


public class Control {
    private String moves;
    private Hero player;    


    public Control(String moves){
        this.moves = moves;

    }


    public Connect(Components c){

    }

    public void moveControl() {
        if (this.moves.isEquals(""))
            moveFile();
        else 
            moveUser();
    }

    public void moveFile() {
        player.setName = "Alcebiades";
        int len = this.moves.length();
        for (int i = 0; i < len; i++){
            char cmd = this.moves.charAt(i);
            switch (cmd) {
                case 'w' :  moveUp();
                case 's' :  moveDown();
                case 'd' :  moveRight();
                case 'a' :  moveLeft();
                case 'k' :  this.player.equip();
                case 'c' :  this.player.collect();
                case 'q' :  quit();

            }
        }

    }

    public void moveUser(){


    }

    public void moveLeft(){
       player.move(player.i, player.j - 1);

    }


    public void moveRight(){
       player.move(player.i, player.j + 1);

    }

    public void moveDown(){
       player.move(player.i + 1, player.j);

    }

    public void moveUp(){
       player.move(player.i - 1, player.j);

    }

    public void quit(){

    }
}
