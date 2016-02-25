package org.academiadecodigo.bootcamp.defectpainter.utility_classes;

import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;
import org.academiadecodigo.bootcamp.defectpainter.MapEditor;

import java.io.*;
import java.util.Iterator;

/**
 * Created by milena, filipe, joana, ita on 25/02/16.
 */
public class Streamer {

    public static Grid load(String file, Grid tempGrid) throws IOException {

        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, using default size");
            e.printStackTrace();
            tempGrid = new Grid(MapEditor.DEFAULT_GRID_SIZE, MapEditor.DEFAULT_GRID_SIZE);
            return tempGrid;
        }

        String line = "";
        String result = "";

        int width = 0;
        int height = 0;

        while ((line = bReader.readLine()) != null) {
            width = line.length();
            height++;
            result += line;
        }
        bReader.close();

        char[] chars = result.toCharArray();

        if (tempGrid == null) {
            tempGrid = new Grid(width, height);
        }

        Iterator<Cell> it = tempGrid.iterator();
        int i = 0;
        while (it.hasNext()) {

            it.next().setState(chars[i++]);

        }
        return tempGrid;

    }

    public static void save(String file, Grid grid) throws IOException {


        Iterator<Cell> it = grid.iterator();
        int i = 0;
        //(w*h)+number os lines, to count with the \n chars
        char[] chars = new char[(grid.getWidth() * grid.getHeight()) + grid.getHeight()];

        while (it.hasNext()) {
            Cell actualCell = it.next();
            chars[i++] = actualCell.getState();
            if (actualCell.getCol() == grid.getWidth() - 1) {
                chars[i++] = '\n';
            }
        }
        BufferedWriter bWriter = null;

        try {
            bWriter = new BufferedWriter(new FileWriter(file));
            bWriter.write(chars);
            //TODO: está a usar alguma coisa do buffer?
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bWriter.close();

        }
    }


}
