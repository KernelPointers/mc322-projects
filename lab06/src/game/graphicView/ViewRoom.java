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
    private boolean isInv;

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

    public boolean hasButton(int i, int j){
        return this.viewCells[i][j].hasButton();
    }

    public BufferedImage getButtonImage(int i, int j){
        return this.viewCells[i][j].getBImg();
    }

    public BufferedImage getImg(int i, int j){
        return this.viewCells[i][j].getImg();
    }

    public char getId(int i, int j){
        return this.viewCells[i][j].getId();
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
    public void update(int i, int j, BufferedImage sprite, char id){
        if (id == 'p'){
            this.playerI = i;
            this.playerJ = j;
        }
        if (this.viewCells[i][j] != null)
            this.viewCells[i][j].setImg(sprite, id);
    }

    @Override
    public void setSubject(Subject sub){
        this.sub = sub;
    }

    @Override
    public void build() {
        if (this.newRoom){

            if (this.sub.getInv()){
                this.isInv = true;
            } else {
                this.isInv = false;
            }

            for (int i = 0; i < this.iNum; i++){
                for (int j = 0; j < this.jNum; j++){
                    ViewCell cell = new ViewCell();
                    char id = sub.getId(i, j);
                    boolean buttonStatus = sub.getButtonStats(i, j);
                    if (id == 'p'){
                        this.playerI = i;
                        this.playerJ = j;
                    }
                  
                    BufferedImage img = sub.getImg(i, j);
                    cell.setImg(img, id);
                    cell.setButton(sub.hasButton(i, j));
                    cell.setButtonStatus(buttonStatus);
                    viewCells[i][j] = cell;
                }
            } 
            this.toogleRoomStatus();
        }
    }

    public boolean getButtonStats(int i, int j){
        return this.sub.getButtonStats(i, j);
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

    @Override
    public boolean isInv() {
        return this.isInv;
    }

    public void toogleInv(){
        if (this.isInv)
            this.isInv = false;
        else
            this.isInv = true;
    }

    @Override
    public BufferedImage getButtonImg(int i, int j) {
        return this.viewCells[i][j].getBImg();
    }

    @Override
    public void setButtonStats(boolean bool, int i, int j) {
        this.viewCells[i][j].setButtonStatus(bool);
    }

    @Override
    public int getIndex(){
        return this.levelIndex;
    }
}
