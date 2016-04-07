package org.academiadecodigo.bootcamp.defectpainter.objects;


import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.MapEditor;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Grid implements Iterable<Cell> {

    private Cell[][] cells;
    private RepresentationFactory factory;

    //initialized just to work while set color is not implemented
    private ColorCorrelation colorCorrelation = ColorCorrelation.BLACK;

    public Grid(RepresentationFactory factory, int width, int height) {

        this.factory = factory;
        cellsInit(width, height);
    }

    private void cellsInit(int width, int height) {

        cells = new Cell[height][width];

        Shapeable cellRepresentation = null;

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                cellRepresentation = factory.getCell(col, row, CellType.RECTANGULAR);
                cells[row][col] = new Cell(col, row, cellRepresentation);
            }
        }
    }

    public char getState(int col, int row) {
        return cells[row][col].getState();
    }

    public void setState(int col, int row, char paint) {
        cells[row][col].setState(paint);
    }

    public Cell getCell(int col, int row) {
        return cells[row][col];
    }

    public void setColorCorrelation(ColorCorrelation colorCorrelation) {
        this.colorCorrelation = colorCorrelation;
        MapEditor.setActiveColor(colorCorrelation);
    }

    /**
     * Converts the grid into a char array
     * @return a char array accordingly to the color that was in each cell
     */
    public char[] convertToCharArray() {

        Iterator<Cell> it = this.iterator();

        int i = 0;

        // initializes a char array with: (w*h)+number of lines -> to count with the '\n' chars in the end of each line
        char[] chars = new char[(this.getWidth() * this.getHeight()) + this.getHeight()];

        while (it.hasNext()) {
            Cell actualCell = it.next();
            chars[i++] = actualCell.getState();
            if (actualCell.getCol() == this.getWidth() - 1) {
                chars[i++] = '\n';
            }
        }

        return chars;
    }

    /**
     * Converts to a Grid from a char array
     * @param chars the array which makes the correlation from the chars to the colors
     */
    public void convertFromCharArray(char[] chars) {

        // section that determines the file size
        int rows = 0;
        int cols = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\n') {
                rows++;
            }
        }

        cols = (chars.length / rows) - 1;

        // if the file size determined previously is not the same as the actual grid size
        // then deletes all previous existing cells and creates a new Cell[][]
        if (rows != this.getHeight() || cols != this.getWidth()) {

            this.delete();
            this.cellsInit(cols, rows);
        }

        // iterates through the Cell[][] and sets it state
        Iterator<Cell> it = this.iterator();
        int i = 0;
        while (it.hasNext()) {
            // skip '\n' chars
            if (chars[i] == '\n') {
                i++;
                continue;
            }
            it.next().setState(chars[i++]);
        }
    }


    public void reset() {

        Iterator<Cell> it = iterator();

        while (it.hasNext()) {
            it.next().setState(ColorCorrelation.WHITE.getState());

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
