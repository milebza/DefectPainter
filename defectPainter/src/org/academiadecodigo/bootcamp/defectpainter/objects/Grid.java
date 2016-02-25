package org.academiadecodigo.bootcamp.defectpainter.objects;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Grid implements Iterable<Cell> {

    private Cell[][] cells;

    public Grid(int width, int height) {

        cells = new Cell[width][height];

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                cells[col][row] = new Cell(col, row);
            }
        }

    }

    public char get(int col, int row) {
        return cells[col][row].getState();
    }

    public void set(int col, int row, char paint) {
        cells[col][row].setState(paint);

    }

    public void changeState(int col, int row) {

        if (get(col, row) == ' ') {
            set(col, row, '*');
        } else {
            set(col, row, ' ');
        }
    }

    public void reset() {

        Iterator<Cell> it = iterator();

        while (it.hasNext()) {
            it.next().setState(' ');

        }
    }

    public int getWidth() {
        return cells[0].length;
    }

    public int getHeight() {
        return cells.length;
    }


    @Override
    public Iterator<Cell> iterator() {
        return new GridIterator();
    }

    private class GridIterator implements Iterator<Cell> {

        private int col = -1;
        private int row = 0;

        @Override
        public boolean hasNext() {

            return row < cells[0].length - 1 || col < cells.length - 1;
        }

        @Override
        public Cell next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (col == cells.length - 1) {
                col = 0;
                row++;
            } else {
                col++;
            }

            return cells[col][row];
        }
    }

}
