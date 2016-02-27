package org.academiadecodigo.bootcamp.defectpainter.objects;


import org.academiadecodigo.bootcamp.defectpainter.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.MapEditor;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Grid implements Iterable<Cell> {

    private Cell[][] cells;

    //initialized just to work while set color is not implemented
    private ColorCorrelation colorCorrelation = ColorCorrelation.BLACK;

    public Grid(RepresentationFactory factory, int width, int height) {

        cells = new Cell[height][width];
        Representable cellRepresentation = null;

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

    //TODO: implementar isto consoante a cor seleccionada pelo rato no menu
    public void setColorCorrelation(ColorCorrelation colorCorrelation) {
        this.colorCorrelation = colorCorrelation;
        //TODO: (Filipe) prefiro que a cor activa esteja como static no MapEditor e assim as Tools acedem facilmente.
        //por agora faz o set no MapEditor aqui. Mas devia a ser feito directamente do MenuPanel.checkAction.
        //O MenuPanel tem que receber grids pq? podia só setar as variaveis static to MapEditor. (activeColor, activeTool, etc)

        MapEditor.setActiveColor(colorCorrelation);
    }

    public ColorCorrelation getColorCorrelation() {
        return colorCorrelation;
    }

    //With tools implemented no use for this.
    public void changeState(int col, int row) {

        if (getState(col, row) == ColorCorrelation.WHITE.getState()) {
            setState(col, row, colorCorrelation.getState());
        } else {
            setState(col, row, ColorCorrelation.WHITE.getState());
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
