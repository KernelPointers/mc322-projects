package game.builder;

import java.io.BufferedReader;
import java.io.FileReader;


public class tileReader {
    String layoutDir = System.getProperty("user.dir") + "/game/builder/layouts/";

    public String getCSV(int csvNum, String csvPath) {
        String buildSet = "";

        try {
            BufferedReader layoutBuffer = new BufferedReader(new FileReader(csvPath));
            try {
                String line = layoutBuffer.readLine();
                while(line != null){
                    buildSet += line;
                    line = layoutBuffer.readLine();
                }
            } catch (Exception error){
                //

            }
            layoutBuffer.close();

        } catch (Exception error){
            System.err.println("Csv file target is empty");
        }

        return buildSet;
    }
    

    public String getNormalCsv(int csvNum){
        String csvPath = layoutDir + "normal/" + csvNum + ".csv";
        return this.getCSV(csvNum, csvPath);
    }

    public String getInvertedCsv(int csvNum){
        String csvPath = layoutDir + "inverted/" + csvNum + ".csv";
        return this.getCSV(csvNum, csvPath);
    }

}

