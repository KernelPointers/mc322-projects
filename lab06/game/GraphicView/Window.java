package game.GraphicView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import game.AppGame;
import game.GraphicView.ProvidedInterfaces.IWindow;
import game.GraphicView.ProvidedInterfaces.ViewInterface;

public class Window extends Canvas implements IWindow, ViewInterface{

    private static final long serialVersionUID = 2L;

    // serialVersionUID

    public Window(int width, int height, String name){// VERIFICAR PARAMETROS DO CONSTRUTOR 
        JFrame frame = new JFrame(name);

        Dimension dim = new Dimension(width, height);

        frame.setPreferredSize(dim);
        frame.setMaximumSize(dim);
        frame.setMinimumSize(dim);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        // game.start();


    }

    public void render(Graphics g){
        this.setTileGrid(g, 1920, 1080, 32, 32);
    }

    public void tick(double dt){

    }

    public void paint(Graphics g, int x, int y) {  
  
        Toolkit t = Toolkit.getDefaultToolkit();  
        String home = System.getProperty("dir");
        Image cellTile = t.getImage("assets/box_temp.jpg");  
        g.drawImage(cellTile, x, y, this);  
          
    }  

    public void setTileGrid(Graphics g, int width, int height, int tileWidth, int tileHeight){
        double xNUm = width / tileWidth;
        double yNUm = height / tileHeight;

        xNUm = Math.floor(xNUm);
        yNUm = Math.floor(yNUm);

        for (int i = 0; i < yNUm; i++){
            int yGap = tileHeight * i;
            for (int j = 0; j < xNUm; j++){
                int xGap = tileWidth * j;
               paint(g, xGap, yGap); 
            }
        }

         
    }

    public void setGraphics(){
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        this.render(g);

        g.dispose();
        bs.show();
    }


}
