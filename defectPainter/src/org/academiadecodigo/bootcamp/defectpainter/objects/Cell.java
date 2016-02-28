package org.academiadecodigo.bootcamp.defectpainter.objects;

import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Cell {

    private int col;
    private int row;
    private char state;
    private Representable representation;

    public Cell(int col, int row, Representable representation) {
        this.col = col;
        this.row = row;
        this.state = ColorCorrelation.WHITE.getState();
        this.representation = representation;
    }

    public void delete() {
        representation.delete();
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

    public Representable getRepresentation() {
        return representation;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {

        this.state = state;

        //ColorCorrelation c = ColorCorrelation.converter(state);

        if (state == ColorCorrelation.WHITE.getState()) {
            this.representation.setColor(state);
            this.representation.draw();
        } else {
            this.representation.setColor(state);
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
