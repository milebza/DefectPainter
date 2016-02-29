package org.academiadecodigo.bootcamp.defectpainter.utility_classes;

import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;
import org.academiadecodigo.bootcamp.defectpainter.MapEditor;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;

import java.io.*;
import java.util.Iterator;

/**
 * Created by milena, filipe, joana, ita on 25/02/16.
 */
public class Streamer {

    public static Grid load(RepresentationFactory factory, String file, Grid tempGrid) throws IOException {

        BufferedReader bReader = null;

        try {
            bReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.getMessage();
            tempGrid = new Grid(factory, MapEditor.DEFAULT_GRID_SIZE, MapEditor.DEFAULT_GRID_SIZE);
            return tempGrid;
        }

        String line = "";
        String result = "";

        // variables to help find the size of the file
        int width = 0;
        int height = 0;

        // reads each line at a time and adds it to a result string
        while ((line = bReader.readLine()) != null) {
            width = line.length();
            height++;
            result += line;
        }
        // close the stream
        bReader.close();

        // converts the result string to a chars array
        char[] chars = result.toCharArray();

        // if the grid that was passed in arguments is null, creates a new one with the file size
        if (tempGrid == null) {
            tempGrid = new Grid(factory, width, height);
        }

        // added to make possible load from a file with different size
        if (tempGrid.getHeight() != height || tempGrid.getWidth() != width) {
            tempGrid.delete();
            tempGrid = new Grid(factory, width, height);
        }

        // invokes an iterator from the grid to set the states of each cell
        Iterator<Cell> it = tempGrid.iterator();
        int i = 0;
        while (it.hasNext()) {

            it.next().setState(chars[i++]);

        }

        return tempGrid;

    }

    public static void save(String file, Grid grid) throws IOException {

        // invokes an iterator from the grid
        Iterator<Cell> it = grid.iterator();
        int i = 0;
        // initializes a char array with: (w*h)+number of lines -> to count with the '\n' chars in the end of each line
        char[] chars = new char[(grid.getWidth() * grid.getHeight()) + grid.getHeight()];

        while (it.hasNext()) {
            Cell actualCell = it.next();
            chars[i++] = actualCell.getState();
            if (actualCell.getCol() == grid.getWidth() - 1) {
                chars[i++] = '\n';
            }
        }

        BufferedWriter bWriter = null;

        // actually writes the chars array in the file
        try {


            bWriter = new BufferedWriter(new FileWriter(file));
            bWriter.write(chars);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bWriter.close();

        }
    }


}
