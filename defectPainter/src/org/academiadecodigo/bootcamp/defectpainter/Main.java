package org.academiadecodigo.bootcamp.defectpainter;


import org.academiadecodigo.bootcamp.defectpainter.objects.ColorPicker;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;
import org.academiadecodigo.bootcamp.defectpainter.simple_graphics.RepresentationGfxFactory;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Main {

    //TODO: THE CONCEPT! PAINT program!

    // RESET KEY_R Button
    //TODO: MENU
    // COLOR PALETTE
    // PAINT DIFFERENT COLORS
    // LOAD/SAVE DIFFERENT COLORS, do a ENUM as DICTIONARY
    //TODO: LOAD/SAVE ASK FILE TO USER
    //TODO: NEW IMAGE(GRID) WITH NEW SIZE
    // SEE IF MOUSE DRAG IS POSSIBLE //IT IS!
    //TODO: PAINT BUCKET
    //TODO: PAINT BRUSH
    //TODO: ERASER
    //TODO: BRUSH/ERASER SIZE
    //TODO: DRAW RECTANGLE FILL AND STROKED
    //TODO: DRAW CIRCLE FILL AND STROKED

    // solved the draw/fill border
    // the error with continuous painting solved
    // added the exit functionality

    public static void main(String[] args) throws InterruptedException {

        RepresentationFactory factory = new RepresentationGfxFactory();

        MapEditor mapEditor = null;
        mapEditor = new MapEditor(factory);

        //ColorPicker cp = new ColorPicker(factory, 10, 10);

        mapEditor.start();

    }
}
