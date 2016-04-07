package org.academiadecodigo.bootcamp.defectpainter.objects;


/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Cursor {

    private int col;
    private int row;
    private int gridWidth;
    private int gridHeight;
    private Movable cursor;
    private boolean on;

    public Cursor(RepresentationFactory factory, int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.col = 0;
        this.row = 0;
        this.cursor = factory.getCursor(col, row, CellType.RECTANGULAR);
        this.setOn(true);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        cursor.move(col - this.col, 0);
        this.col = col;
    }

    public void setRow(int row) {
        cursor.move(0, row - this.row);
        this.row = row;
    }

    /**
     * Moves the cursor to a given cell
     * @param col column to move to
     * @param row row to move to
     */
    public void moveTo(int col, int row) {
        setCol(col);
        setRow(row);
    }

    public boolean isOn() {
        return on;
    }

    public void delete() {
        cursor.delete();
    }

    public void setOn(boolean on) {

        this.on = on;
        if (on) {
            cursor.draw();
        } else {
            cursor.delete();
        }
    }

    public void moveUp() {
        if (row != 0) {
            row--;
            cursor.move(0, -1);
        }
    }

    public void moveDown() {
        if (row != gridHeight - 1) {
            row++;
            cursor.move(0, 1);
        }
    }

    public void moveRight() {
        if (col != gridWidth - 1) {
            col++;
            cursor.move(1, 0);
        }
    }

    public void moveLeft() {
        if (col != 0) {
            col--;
            cursor.move(-1, 0);
        }
    }

}
