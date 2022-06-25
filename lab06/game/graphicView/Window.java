package game.graphicView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.io.File;

import game.AppGame;
import game.controller.ProvidedInterfaces.IKeyboard;
import game.graphicView.ProvidedInterfaces.IWindow;
import game.graphicView.RequiredInterfaces.RIKeyboardInput;

public class Window extends Canvas implements IWindow, RIKeyboardInput{

    private int width, height; 
    private String name;
    private IntViewRoom viewRoom;
    private IKeyboard keyInput;

    // serialVersionUID

    public Window(int width, int height, String name){
        this.name = name;
        this.width = width;
        this.height = height;

        JFrame frame = new JFrame(this.name);
        
        Dimension dim = new Dimension(this.width, this.height);

        frame.setPreferredSize(dim);
        frame.setMaximumSize(dim);
        frame.setMinimumSize(dim);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);


    }


    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public String getName(){
        return this.name;
    }
    public void render(Graphics g, int width, int height){


        this.setTileGrid(g, width, height, 80, 72);

        this.displayViewMatrix(g, width, height);


    }

    public void tick(double dt){
        
    }

    public void paintComponent(Graphics g, int x, int y, BufferedImage img) {  
  
            g.drawImage(img, x, y, this);

    }  

    public void setTileGrid(Graphics g, int width, int height, int tileWidth, int tileHeight){
        double xNUm = width / tileWidth;
        double yNUm = height / tileHeight;

        try {
            BufferedImage cellTile = ImageIO.read(new File("assets/cell_temp_i.jpg"));  

            //xNUm = Math.floor(xNUm);
            //yNUm = Math.floor(yNUm);

            for (int i = 0; i < yNUm; i++){
                int yGap = tileHeight * i;
                for (int j = 0; j < xNUm; j++){
                    int xGap = tileWidth * j;
                    paintComponent(g, xGap, yGap, cellTile); 
            }
        }

         
        }catch (Exception error){
            System.err.println("Empty image file for cellTile");
        }

    }

    public void displayViewMatrix(Graphics g, int width, int height){
       double xNUm = width / 80;
       double yNUm = height / 72;

       for (int i = 0; i  < yNUm; i++){
           int y = 72 * i; 
           for (int j = 0; j < xNUm; j++){
                int x = 80 * j; 
                this.paintComponent(g, x, y, this.viewRoom.getImg(i, j));
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

        this.render(g, this.width, this.height);

        g.dispose();
        bs.show();
    }


    @Override
    public void connect(IntViewRoom viewRoom) {
        this.viewRoom = viewRoom;
    }

    @Override
    public void connectKeyInput(IKeyboard keyInput){
        this.keyInput = keyInput;
        this.addKeyListener(keyInput);
    }

}
