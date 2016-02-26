package org.academiadecodigo.bootcamp.defectpainter.objects;


import org.academiadecodigo.bootcamp.defectpainter.ColorCorrelation;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Grid implements Iterable<Cell> {

    private Cell[][] cells;

    //initialized just to work while set color is not implemented
    ColorCorrelation colorCorrelation = ColorCorrelation.BLACK;

    public Grid(int width, int height) {

        cells = new Cell[height][width];

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                cells[row][col] = new Cell(col, row);
            }
        }

    }

    public char get(int col, int row) {
        return cells[row][col].getState();
    }

    public void set(int col, int row, char paint) {
        cells[row][col].setState(paint);

    }

    //TODO: implementar isto consoante a cor seleccionada pelo rato no menu
    public void setColorCorrelation(ColorCorrelation colorCorrelation) {
        this.colorCorrelation = colorCorrelation;
    }

    public void changeState(int col, int row) {

        if (get(col, row) == ' ') {
            set(col, row, colorCorrelation.getState());
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

    public void delete() {

        Iterator<Cell> it = iterator();

        while (it.hasNext()) {
            it.next().delete();

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

            return col < cells[0].length - 1 || row < cells.length - 1;
        }

        @Override
        public Cell next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (col == cells[0].length - 1) {
                col = 0;
                row++;
            } else {
                col++;
            }

            return cells[row][col];
        }
    }

}
