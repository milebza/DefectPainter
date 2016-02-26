package org.academiadecodigo.bootcamp.defectpainter.objects;


import org.academiadecodigo.bootcamp.defectpainter.ColorCorrelation;
import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MenuPanel {
    //TODO: Colors to add, 6 colors: white, black, red, green, blue, yellow.

    private static final int SECTION_MARGIN = 1;
    private ColorPicker colorPicker;
    private Cell[] selectedColor;


    public MenuPanel(RepresentationFactory factory, int colOffset) {

        //TODO: Separate sections init stuff

        initColorPicker(factory, colOffset);

        initCurrentColorSection(factory, colOffset);

    }

    private void initColorPicker(RepresentationFactory factory, int colOffset) {
        this.colorPicker = new ColorPicker(factory, colOffset);
    }

    private void initCurrentColorSection(RepresentationFactory factory, int colOffset) {
        Representable cellRepresentation = null;
        this.selectedColor = new Cell[colorPicker.getWidth() - colOffset];

        for (int i = 0; i < selectedColor.length; i++) {
            cellRepresentation = factory.getCell(colOffset + i, colorPicker.getHeight() + SECTION_MARGIN, CellType.RECTANGULAR);
            selectedColor[i] = new Cell(colOffset + i, colorPicker.getHeight() + SECTION_MARGIN, cellRepresentation);
        }
    }

    public void checkAction(Grid grid, int col, int row) {

        if (col < colorPicker.getWidth() && row < colorPicker.getHeight()) {

            // get current color colorCorrelation
            ColorCorrelation colorCorrelation = ColorCorrelation.converter(colorPicker.getColor(col - grid.getWidth() - 1, row));

            // change current color to paint in grid
            grid.setColorCorrelation(colorCorrelation);

            // change current color cells to current color
            for (int i = 0; i < selectedColor.length; i++) {
                selectedColor[i].setState(colorCorrelation.getState());
            }

        }

    }

    public void delete() {
        colorPicker.delete();

        for (int i = 0; i < selectedColor.length; i++) {
            selectedColor[i].delete();
        }
    }

    public int getWidth() {
        return colorPicker.getWidth();
    }

    public int getHeight() {
        return colorPicker.getHeight();
    }

}
