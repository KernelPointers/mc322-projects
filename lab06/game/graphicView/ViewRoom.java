package game.graphicView;

import java.awt.Graphics;
import java.util.ArrayList;

import game.graphicView.ProvidedInterfaces.ViewInterface;
import game.world.Subject;

public class ViewRoom implements Observer, ViewInterface{
    private int iNum, jNum;
    private ViewCell[][] viewCells;
    private Subject sub;

    public ViewRoom(int iNum, int jNUm){
        this.iNum = iNum;
        this.jNum = jNUm;
        this.viewCells = new ViewCell[iNum][jNum];
    }

    public void update(){

    }

    public void setSubject(Subject sub){
        this.sub = sub;
    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void tick(double dt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setGraphics() {
        // TODO Auto-generated method stub
        
    }
}
