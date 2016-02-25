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
