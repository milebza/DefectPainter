package org.academiadecodigo.bootcamp.defectpainter;


import org.academiadecodigo.bootcamp.defectpainter.objects.ColorPicker;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;
import org.academiadecodigo.bootcamp.defectpainter.simple_graphics.RepresentationGfxFactory;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        RepresentationFactory factory = new RepresentationGfxFactory();

        MapEditor mapEditor = null;
        mapEditor = new MapEditor(factory);

        //ColorPicker cp = new ColorPicker(factory, 10, 10);

        mapEditor.start();


        //TODO: THE CONCEPT! PAINT program!

        // RESET KEY_R Button
        //TODO: MENU
        // COLOR PALETTE
        // PAINT DIFFERENT COLORS
        // LOAD/SAVE DIFFERENT COLORS, do a ENUM as DICTIONARY
        //TODO: LOAD/SAVE ASK FILE TO USER
        //TODO: NEW IMAGE(GRID) WITH NEW SIZE
        //TODO: SEE IF MOUSE DRAG IS POSSIBLE
        //TODO: PAINT BUCKET
        //TODO: PAINT BRUSH
        //TODO: ERASER
        //TODO: BRUSH/ERASER SIZE
        //TODO: DRAW RECTANGLE FILL AND STROKED
        //TODO: DRAW CIRCLE FILL AND STROKED

        // solved the draw/fill border
        // the error with continuous painting solved
        // added the exit functionality


        /*Iterator it = mapEditor.getGrid().iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }*/
/*
        mapEditor.getGrid().set(0, 0, 'F');
        mapEditor.getGrid().set(4, 3, 'F');

        try {
            mapEditor.save("resources/testeF.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        //Rectangle rec = new Rectangle()

    }
}
