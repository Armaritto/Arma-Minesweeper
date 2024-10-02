package com.example.armasweeper;

import java.util.Arrays;
import java.util.Random;
public class Minesweeper {
    private int[][] field; // -1 for mine, 0 for empty, 1-8 for number of mines around
    private boolean[][] opened;
    private boolean[][] flagged;
    private final int mines;
    private final int rows;
    private final int cols;
    private final int startX;
    private final int startY;
    private int openedCells; // number of opened cells
    public int[][] getField() {
        return field;
    }
    public void setField(int[][] field) {
        this.field = field;
    }
    public boolean[][] getOpened() {
        return opened;
    }
    public void setOpened(boolean[][] opened) {
        this.opened = opened;
    }
    public boolean[][] getFlagged() {
        return flagged;
    }
    public void setFlagged(boolean[][] flagged) {
        this.flagged = flagged;
    }
    public int getMines() {
        return mines;
    }
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
    public int getOpenedCells() {
        return openedCells;
    }
    public void setOpenedCells(int openedCells) {
        this.openedCells = openedCells;
    }
    public Minesweeper(int rows, int cols, int mines, int startX, int startY) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.startX = startX;
        this.startY = startY;
        field = new int[rows][cols];
        opened = new boolean[rows][cols];
        flagged = new boolean[rows][cols];
        openedCells = 0;
    }
    public void generateGame(){
        for(int i=0;i<mines;){
            Random rand = new Random();
            int row = rand.nextInt(rows);
            int col = rand.nextInt(cols);
            if(field[row][col] != -1 && startX != row && startY != col){
                i++;
                field[row][col] = -1;
            }
        }
        int[] n = {-1 , 0 , 1};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(field[i][j] == -1){
                    int a,b;
                    for(int k : n){
                        for(int l : n){
                            a = i+k;
                            b = j+l;
                            if(!(a == i && b == j) && a<rows && b<cols && a>=0 && b>=0 && field[a][b] != -1)
                                field[a][b]++;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<rows;i++){
            s.append(Arrays.toString(field[i]));
            s.append("\n");
        }
        return s.toString();
    }
}
