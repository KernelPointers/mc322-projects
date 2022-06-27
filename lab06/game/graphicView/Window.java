package game.graphicView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.io.File;

import game.controller.ProvidedInterfaces.IKeyboard;
import game.graphicView.ProvidedInterfaces.IWindow;
import game.graphicView.ProvidedInterfaces.ICamera;
import game.graphicView.RequiredInterfaces.RIKeyboardInput;

public class Window extends Canvas implements IWindow, RIKeyboardInput, ICamera{
    private JFrame frame;
    private InnerPanel panel;
    private int width, height; 
    private double angle = 0, rot = Math.PI / 40; // 4.5 graus
    private String name;
    private IntViewRoom viewRoom;
    private IKeyboard keyInput;

    // serialVersionUID

    public Window(int width, int height, String name){
        this.name = name;
        this.width = width;
        this.height = height;

        this.frame = new JFrame(this.name);
        this.panel = new InnerPanel(this.width, this.height, this);

        this.frame.add(panel);
        this.frame.pack();

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.add(this);


    }

    public void showWindow(){
        this.frame.setVisible(true);
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
    public void render(Graphics2D g, int width, int height){


        this.setTileGrid(g, width, height, 80, 72);

        this.displayViewMatrix(g, width, height);


    }

    public void tick(double dt){
        
    }

    public int transformX(int x){
        int tileWidth = 80;
        return x - 
            (this.viewRoom.getPlayerJ() * 80 ) + 
            (this.viewRoom.getPlayerScreenJ() * 80);
    }

    public int transformY(int y){
        return y - 
            (this.viewRoom.getPlayerI() * 72) + 
            (this.viewRoom.getPlayerScreenI() * 72);
    }

    public void drawComponent(Graphics2D g, int x, int y, BufferedImage[] img) {  
        if (!(img == null)){
            int newX = transformX(x);
            int newY = transformY(y);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                               RenderingHints.VALUE_ANTIALIAS_ON);
            AffineTransform restoreMatrix = g.getTransform();
            g.rotate(this.angle, newX, newY);
            for (int i = 0; i < img.length; i++){
                //int dist = i + z;
                //float lx = dist * angCos
                //float ly = dist * angSin
                g.drawImage(img[i], newX, newY, this);
                //this.getBufferStrategy().show();
            }
            g.setTransform(restoreMatrix);
        }


    }  

    public void setTileGrid(Graphics2D g, int width, int height, int tileWidth, int tileHeight){
        int xNUm = this.viewRoom.getJnum();
        double yNUm = this.viewRoom.getInum();
        int num = 1; // NUMERO DE SPRITES BASE
        BufferedImage[] img = new BufferedImage[num];
            for (int i = 0; i < num; i++){
            String sprite_name = "assets/stacked_dirt_floor/" + i + ".png"; 
            try {
                img[i] = ImageIO.read(new File(sprite_name));
            } catch (Exception err){

           }
            }
        
            for (int i = 0; i < yNUm; i++){
                int yGap = tileHeight * i;
                for (int j = 0; j < xNUm; j++){
                    int xGap = tileWidth * j;
                    this.drawComponent(g, xGap, yGap, img); 
                }
            }

      

    }

    public void displayViewMatrix(Graphics2D g, int width, int height){
       double xNUm = this.viewRoom.getJnum();
       double yNUm = this.viewRoom.getInum();

       for (int i = 0; i  < yNUm; i++){
           int y = 72 * i; 
           for (int j = 0; j < xNUm; j++){
                int x = 80 * j; 
                this.drawComponent(g, x, y, this.viewRoom.getImg(i, j));
           }
       } 
    }



    @Override
    public void connect(IntViewRoom viewRoom) {
        this.viewRoom = viewRoom;
    }

    @Override
    public void connectKeyInput(IKeyboard keyInput){
        this.panel.addKeyListener(keyInput);
        this.panel.setFocusable(true);
    }

    @Override
    public void updateCanvas(){
        this.panel.repaint();
    }

    @Override
    public void rotateCamera(char dir) {
        if (dir == 'l')
            this.angle += rot;
        else
            this.angle -= rot; 
    }


}
