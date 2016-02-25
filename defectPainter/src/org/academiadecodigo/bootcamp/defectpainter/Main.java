package org.academiadecodigo.bootcamp.defectpainter;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Main {
    public static void main(String[] args) {

        MapEditor mapEditor = null;

        try {
            mapEditor = new MapEditor("resources/test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }




        Iterator it = mapEditor.getGrid().iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
