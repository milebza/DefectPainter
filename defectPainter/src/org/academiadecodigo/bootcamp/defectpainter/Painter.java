package org.academiadecodigo.bootcamp.defectpainter;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Painter {

    private int col;
    private int row;
    private int width;
    private int height;

    public Painter(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void moveUp() {
        if (row != 0) {
            row--;
        }
    }

    public void moveDown() {
        if (row != height) {
            row++;
        }
    }

    public void moveRight() {
        if (col != width) {
            col++;
        }
    }

    public void moveLeft() {
        if (col != 0) {
            col--;
        }
    }

}
