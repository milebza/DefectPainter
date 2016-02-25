package org.academiadecodigo.bootcamp.defectpainter;

import org.academiadecodigo.bootcamp.defectpainter.simple_graphics.CellGfx;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Cell {

    private int col;
    private int row;
    private char state;
    private Representable representation;

    public Cell(int col, int row) {
        this.col = col;
        this.row = row;
        this.state = ' ';
        this.representation = new CellGfx(col, row);

    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {

        this.state = state;

        if (state == ' ') {
            this.representation.draw();
        } else {
            this.representation.fill();
        }
    }

    @Override
    public String toString() {
        return "Cell{" +
                "col=" + col +
                ", row=" + row +
                ", state=" + state +
                '}';
    }
}
