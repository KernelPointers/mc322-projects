package game.graphicView;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
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

        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    } 

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;


        window.displayViewMatrix(g2, this.window.getWidth(), this.window.getHeight());

        g2.dispose();

    }

    
}
