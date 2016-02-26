package org.academiadecodigo.bootcamp.defectpainter.objects;

import org.academiadecodigo.bootcamp.defectpainter.simple_graphics.MovableRepresentation;
import org.academiadecodigo.bootcamp.defectpainter.simple_graphics.PainterGfx;


/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Painter {

    private int col;
    private int row;
    private int gridWidth;
    private int gridHeight;
    private MovableRepresentation painter;
    private boolean on;

    public Painter(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.col = 0;
        this.row = 0;
        this.painter = new PainterGfx(col, row);
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

    public boolean isOn() {
        return on;
    }

    public void delete() {
        painter.delete();
    }

    public void setOn(boolean on) {

        this.on = on;
        if (on) {
            painter.fill();
        } else {
            painter.delete();
        }
    }

    public void moveUp() {
        if (row != 0) {
            row--;
            painter.move(0, -1);
        }
    }

    public void moveDown() {
        if (row != gridHeight - 1) {
            row++;
            painter.move(0, 1);
        }
    }

    public void moveRight() {
        if (col != gridWidth - 1) {
            col++;
            painter.move(1, 0);
        }
    }

    public void moveLeft() {
        if (col != 0) {
            col--;
            painter.move(-1, 0);
        }
    }

}
