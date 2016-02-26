package org.academiadecodigo.bootcamp.defectpainter.objects;

import org.academiadecodigo.bootcamp.defectpainter.ColorCorrelation;
import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class ColorPicker {
    private static final int DEFAULT_COLORS_PER_LINE = 2;
    private int col;
    //private int row;
    private Cell[][] colorPalette;


    public ColorPicker(RepresentationFactory factory, int colOffset) {
        this.col = colOffset;
        //this.row = 0;
        init(factory, DEFAULT_COLORS_PER_LINE);
    }

    public ColorPicker(RepresentationFactory factory, int colOffset, int numberOfColorsPerLine) {
        this.col = colOffset;
        //this.row = 0;
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

                representation = factory.getCell(col + j, i, CellType.RECTANGULAR);
                representation.setColor((ColorCorrelation.values()[colorIndex].getColor()));

                colorPalette[i][j] = new Cell(col + j, i, representation);

                colorPalette[i][j].setState(ColorCorrelation.values()[colorIndex].getState());

                // check if color is white
                System.out.println("init with color " + ColorCorrelation.values()[colorIndex]);

                colorIndex++;

            }

        }

    }

    public char getColor(int col, int row) {
        return colorPalette[row][col].getState();
    }

}
