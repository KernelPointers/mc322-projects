package game.graphicView;

import java.awt.image.BufferedImage;

import game.world.Subject;

public class ViewRoom implements IntViewRoom{
    private int iNum = 30, jNum = 48;
    private int levelIndex;
    private int playerI, playerJ;
    private int playerScreenI = 7, playerScreenJ = 12;
    private ViewCell[][] viewCells;
    private Subject sub;
    private boolean newRoom = true;

    public ViewRoom(){
        this.viewCells = new ViewCell[iNum][jNum];
    }

    public void setInum(int iNum){
        this.iNum = iNum;
    }

    public int getInum(){
        return this.iNum;
    }

    public void setJnum(int jNum){
        this.jNum = jNum;
    }

    public int getJnum(){
        return this.jNum;
    }

    public BufferedImage[] getImg(int i, int j){
        return this.viewCells[i][j].getImg();
    }

    public void setLevelIndex(int levelIndex){
        this.levelIndex = levelIndex;
    }

    public int getLevelIndex(){
        return this.levelIndex;
    }


    public void toogleRoomStatus(){
        if (this.newRoom)
            this.newRoom = false;
        else
            this.newRoom = true;
    }

    @Override
    public void update(int i, int j, BufferedImage[] sprite, char id){
        if (id == 'p'){
            this.playerI = i;
            this.playerJ = j;
        }
        this.viewCells[i][j].setImg(sprite, id);
    }

    @Override
    public void setSubject(Subject sub){
        this.sub = sub;
    }

    @Override
    public void build() {
        if (this.newRoom){
            // clearscreen
            for (int i = 0; i < this.iNum; i++){
                for (int j = 0; j < this.jNum; j++){
                    ViewCell cell = new ViewCell();
                    char id = sub.getId(i, j);
                    if (id == 'p'){
                        this.playerI = i;
                        this.playerJ = j;
                    }
                    BufferedImage[] img = sub.getImg(i, j);
                    cell.setImg(img, id);
                    viewCells[i][j] = cell;
                }
            } 
            this.toogleRoomStatus();
        }
    }


    public int getPlayerI(){
        return this.playerI;
    }

    public int getPlayerJ(){
        return this.playerJ;
    }

    public int getPlayerScreenI(){
        return this.playerScreenI;
    }

    public int getPlayerScreenJ(){
        return this.playerScreenJ;
    }
}
