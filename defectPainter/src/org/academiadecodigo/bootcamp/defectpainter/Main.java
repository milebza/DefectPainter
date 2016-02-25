package org.academiadecodigo.bootcamp.defectpainter;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        MapEditor mapEditor = null;


        mapEditor = new MapEditor();


        mapEditor.start();

        //TODO: THE CONCEPT! PAINT program!

        //TODO: RESET KEY_R Button
        //TODO: MENU
        //TODO: COLOR PALETTE
        //TODO: PAINT DIFFERENT COLORS
        //TODO: LOAD/SAVE DIFFERENT COLORS, do a ENUM as DICTIONARY
        //TODO: LOAD/SAVE ASK FILE TO USER
        //TODO: NEW IMAGE(GRID) WITH NEW SIZE
        //TODO: SEE IF MOUSE DRAG IS POSSIBLE
        //TODO: PAINT BUCKET
        //TODO: PAINT BRUSH
        //TODO: ERASER
        //TODO: BRUSH/ERASER SIZE
        //TODO: DRAW RECTANGLE FILL AND STROKED
        //TODO: DRAW CIRCLE FILL AND STROKED



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
