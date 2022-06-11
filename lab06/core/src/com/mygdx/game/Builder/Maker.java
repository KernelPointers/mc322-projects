package com.mygdx.game.Builder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class Maker {
    private String layoutDir = System.getProperty("user.dir") + "/core/src/com/mygdx/game/Builder/layouts/";
    private BufferedReader layoutBuffer;
    public String input = "";
    

    public void make(int layoutNum){
        String layoutFile = this.layoutDir + "layout" + layoutNum + ".csv";

        try {
            this.layoutBuffer = new BufferedReader(new FileReader(layoutFile));
        } catch (Exception error){
            System.err.println("Vc fez algo de errado");
        }

        try {
             String line = this.layoutBuffer.readLine();
             while (line != null) {
                this.input += line;
                line = this.layoutBuffer.readLine();
            }
            layoutBuffer.close();
        } catch (Exception error){
                System.err.println("Vc fez algo de errado");
        }


    }

}



