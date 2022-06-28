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

public class Window extends Canvas implements IWindow, RIKeyboardInput{
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


        //this.setTileGrid(g, width, height, 80, 72);

        this.displayViewMatrix(g, width, height);


    }

    public void tick(double dt){
        
    }

    public int transformX(int x){
        int tileWidth = 80;
        return x - 
            (this.viewRoom.getPlayerJ() * tileWidth ) + 
            (this.viewRoom.getPlayerScreenJ() * tileWidth);
    }

    public int transformY(int y){
        int tileHeight = 72;
        return y - 
            (this.viewRoom.getPlayerI() * tileHeight) + 
            (this.viewRoom.getPlayerScreenI() * tileHeight);
    }

    public void drawComponent(Graphics2D g, int x, int y, BufferedImage img) {  
        if (img != null){
            int newX = transformX(x);
            int newY = transformY(y);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                               RenderingHints.VALUE_ANTIALIAS_ON);
            AffineTransform restoreMatrix = g.getTransform();
            g.rotate(this.angle, this.viewRoom.getPlayerScreenI(), 
            this.viewRoom.getPlayerScreenJ());
                    //this.transformX(this.viewRoom.getPlayerJ()), 
                    //this.transformY(this.viewRoom.getPlayerI()));
                //int dist = i + z;
                //float lx = dist * angCos
                //float ly = dist * angSin
            g.drawImage(img, newX, newY, 80, 80, this);
                //this.getBufferStrategy().show();
            g.setTransform(restoreMatrix);
        }


    }  


    public void displayViewMatrix(Graphics2D g, int width, int height){
       double xNUm = this.viewRoom.getJnum();
       double yNUm = this.viewRoom.getInum();
        int num = 2;
        BufferedImage[] img = new BufferedImage[num];
        for(int k = 0; k < num; k++){
            String sprite_name = "assets/floor/" + k + ".png"; 
            try {
                img[k] = ImageIO.read(new File(sprite_name));
            } catch (Exception err){

            }
        }

        BufferedImage current;
        if (this.viewRoom.isInv())
            current = img[1];
        else
            current = img[0];



       for (int i = 0; i  < yNUm; i++){
           int y = 80 * i; 
           for (int j = 0; j < xNUm; j++){
                int x = 80 * j; 
                char id = this.viewRoom.getId(i, j);
                boolean button = viewRoom.hasButton(i, j);
                if(id != 'v'){
                   
                    this.drawComponent(g, x, y, current); 

                    if (button){
                        this.viewRoom.setButtonStats(this.viewRoom.getButtonStats(i, j), i, j);
                        this.drawComponent(g, x, y, this.viewRoom.getButtonImg(i, j));
                    }
                    
                    if (id != '#')    
                        this.drawComponent(g, x, y, this.viewRoom.getImg(i, j));
                }

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
