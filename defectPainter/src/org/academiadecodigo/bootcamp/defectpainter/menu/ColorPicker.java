package org.academiadecodigo.bootcamp.defectpainter.menu;

import org.academiadecodigo.bootcamp.defectpainter.menu.buttons.ColorButton;
import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.objects.*;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class ColorPicker {

    private static final int DEFAULT_COLORS_PER_LINE = 2;
    private int colOffset;
    private ColorButton[][] colorButtons;

    public ColorPicker(RepresentationFactory factory, int colOffset) {
        this.colOffset = colOffset;
        init(factory, DEFAULT_COLORS_PER_LINE);
    }

    private void init(RepresentationFactory factory, int numberOfColorsPerLine) {
        int rows = ColorCorrelation.values().length / numberOfColorsPerLine;
        int cols = numberOfColorsPerLine;

        colorButtons = new ColorButton[rows][cols];
        int colorIndex = 0;
        Shapeable representation = null;

        for (int i = 0; i < colorButtons.length; i++) {

            for (int j = 0; j < colorButtons[i].length; j++) {

                //representation may change, this is just to check if it's in the right spot
                representation = factory.getColorButton(colOffset + j, i, CellType.ROUND);
                representation.setColor((ColorCorrelation.values()[colorIndex].getState()));
                representation.fill();
                colorButtons[i][j] = new ColorButton(ColorCorrelation.values()[colorIndex], representation);

                colorIndex++;
            }
        }
    }

    public void delete() {
        for (int i = 0; i < colorButtons.length; i++) {

            for (int j = 0; j < colorButtons[i].length; j++) {
                colorButtons[i][j].delete();
            }
        }
    }

    public char getColor(int col, int row) {
        return colorButtons[row][col].getColorCorrelation().getState();
    }

    public int getWidth() {
        return colorButtons[0].length + colOffset;
    }

    public int getHeight() {
        return colorButtons.length;
    }

}
