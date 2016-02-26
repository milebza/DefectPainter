package org.academiadecodigo.bootcamp.defectpainter.objects;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MenuPanel {
    //TODO: Colors to add, 6 colors: white, black, red, green, blue, yellow.

    private ColorPicker colorPicker;


    public MenuPanel(RepresentationFactory factory, int colOffset) {
        this.colorPicker = new ColorPicker(factory, colOffset);
    }


    //Legend

    //Color picker


}
