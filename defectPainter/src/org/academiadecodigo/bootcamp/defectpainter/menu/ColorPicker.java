package org.academiadecodigo.bootcamp.defectpainter.menu;

import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.CellType;
import org.academiadecodigo.bootcamp.defectpainter.objects.Representable;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class ColorPicker {
    private static final int DEFAULT_COLORS_PER_LINE = 2;
    private int col;
    private Cell[][] colorPalette;

    public Cell[][] getColorPalette() {
        return colorPalette;
    }

    public ColorPicker(RepresentationFactory factory, int colOffset) {
        this.col = colOffset;
        init(factory, DEFAULT_COLORS_PER_LINE);
    }

    public ColorPicker(RepresentationFactory factory, int colOffset, int numberOfColorsPerLine) {
        this.col = colOffset;
        init(factory, numberOfColorsPerLine);
    }

    private void init(RepresentationFactory factory, int numberOfColorsPerLine) {
        int rows = ColorCorrelation.values().length / numberOfColorsPerLine;
        int cols = numberOfColorsPerLine;

        colorPalette = new Cell[rows][cols];
        int colorIndex = 0;
        Representable representation = null;

        for (int i = 0; i < colorPalette.length; i++) {

            for (int j = 0; j < colorPalette[i].length; j++) {

                representation = factory.getCell(col + j, i, CellType.ROUND);
                representation.setColor((ColorCorrelation.values()[colorIndex].getState()));

                colorPalette[i][j] = new Cell(col + j, i, representation);

                colorPalette[i][j].setState(ColorCorrelation.values()[colorIndex].getState());

                colorIndex++;

            }

        }

    }

    public void delete() {
        for (int i = 0; i < colorPalette.length; i++) {

            for (int j = 0; j < colorPalette[i].length; j++) {
                colorPalette[i][j].delete();
            }

        }
    }

    public char getColor(int col, int row) {
        return colorPalette[row][col].getState();
    }

    public int getWidth() {
        return colorPalette[0].length + col;
    }

    public int getHeight() {
        return colorPalette.length;
    }

}
