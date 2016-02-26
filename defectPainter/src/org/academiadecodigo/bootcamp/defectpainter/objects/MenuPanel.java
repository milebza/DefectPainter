package org.academiadecodigo.bootcamp.defectpainter.objects;


import org.academiadecodigo.bootcamp.defectpainter.ColorCorrelation;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MenuPanel {
    //TODO: Colors to add, 6 colors: white, black, red, green, blue, yellow.

    //private Cell selectedColor;
    private ColorPicker colorPicker;


    public MenuPanel(RepresentationFactory factory, int colOffset) {

        this.colorPicker = new ColorPicker(factory, colOffset);
    }

    public void checkAction(Grid grid, int col, int row) {

        if (col < colorPicker.getWidth() && row < colorPicker.getHeight()) {

            System.out.println("Color changed to: " + ColorCorrelation.converter(colorPicker.getColor(col - grid.getWidth() - 1, row)));

            grid.setColorCorrelation(ColorCorrelation.converter(colorPicker.getColor(col - grid.getWidth() - 1, row)));
        }

    }

    public int getWidth() {
        return colorPicker.getWidth();
    }

    public int getHeight() {
        return colorPicker.getHeight();
    }

}
