package org.academiadecodigo.bootcamp.defectpainter;

import java.io.*;
import java.util.Iterator;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MapEditor {

    private final int DEFAULT_GRID_SIZE = 10;
    private Grid grid;
    private Painter painter;
    private String file;


    public MapEditor() {
        this.grid = new Grid(DEFAULT_GRID_SIZE, DEFAULT_GRID_SIZE);
    }

    public MapEditor(int w, int h) {
        this.grid = new Grid(w, h);
    }

    public MapEditor(String file) throws IOException {
        this.file = file;
        this.grid = load(file);
    }

    public Grid getGrid() {
        return grid;
    }

    public Grid load(String file) throws IOException {

        Grid tempGrid;

        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found, using default size");
            tempGrid = new Grid(DEFAULT_GRID_SIZE, DEFAULT_GRID_SIZE);
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

        tempGrid = new Grid(width, height);

        Iterator<Cell> it = tempGrid.iterator();
        int i = 0;
        while (it.hasNext()) {

            it.next().setState(chars[i++]);

        }
        return tempGrid;


    }

    public void save(String file) throws IOException {


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
