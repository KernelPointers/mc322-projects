package game.graphicView;

import javax.swing.GrayFilter;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Dimension;

public class InnerPanel extends JPanel {
    private Window window;

    public InnerPanel(int width, int height, Window wind){
        this.window = wind;

        Dimension dim = new Dimension(width, height);

        this.setPreferredSize(dim);
        this.setMaximumSize(dim);
        this.setMinimumSize(dim);

        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

    } 

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;


        window.setTileGrid(g, this.window.getWidth(), this.window.getHeight(), 80, 72);
        window.displayViewMatrix(g, this.window.getWidth(), this.window.getHeight());

        g.dispose();
        g2.dispose();

    }

    
}
