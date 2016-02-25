package org.academiadecodigo.bootcamp.defectpainter;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MapEditor implements KeyboardHandler {

    private final int DEFAULT_GRID_SIZE = 10;
    private Grid grid;
    private Painter painter;
    private String file;
    private boolean spaceHold;
    private Queue<KeyboardEvent> queue = new LinkedList<>();
    private Keyboard k;


    public MapEditor() {
        this.grid = new Grid(DEFAULT_GRID_SIZE, DEFAULT_GRID_SIZE);
        this.painter = new Painter(grid.getWidth(), grid.getHeight());
        configKeys();
    }

    public MapEditor(int w, int h) {
        this.grid = new Grid(w, h);
        this.painter = new Painter(grid.getWidth(), grid.getHeight());
        configKeys();
    }

    public MapEditor(String file) throws IOException {
        this.file = file;
        this.grid = load(file);
        this.painter = new Painter(grid.getWidth(), grid.getHeight());
        configKeys();
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
            e.printStackTrace();
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

    private void configKeys() {

        k = new Keyboard(this);

        KeyboardEvent keyUp = new KeyboardEvent();
        keyUp.setKey(KeyboardEvent.KEY_UP);
        keyUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyUp);

        KeyboardEvent keyDown = new KeyboardEvent();
        keyDown.setKey(KeyboardEvent.KEY_DOWN);
        keyDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyDown);

        KeyboardEvent keyLeft = new KeyboardEvent();
        keyLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyLeft);

        KeyboardEvent keyRight = new KeyboardEvent();
        keyRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyRight);

        KeyboardEvent keyLoad = new KeyboardEvent();
        keyLoad.setKey(KeyboardEvent.KEY_L);
        keyLoad.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyLoad);

        KeyboardEvent keySave = new KeyboardEvent();
        keySave.setKey(KeyboardEvent.KEY_S);
        keySave.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keySave);

        KeyboardEvent keySpacePress = new KeyboardEvent();
        keySpacePress.setKey(KeyboardEvent.KEY_SPACE);
        keySpacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keySpacePress);

        KeyboardEvent keySpaceRel = new KeyboardEvent();
        keySpaceRel.setKey(KeyboardEvent.KEY_SPACE);
        keySpaceRel.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(keySpaceRel);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        queue.offer(e);
    }

    public void pollEvents() {
        KeyboardEvent event = queue.poll();
        if (event.getKeyboardEventType() == KeyboardEventType.KEY_PRESSED) {
            switch (event.getKey()) {
                case KeyboardEvent.KEY_UP:
                    painter.moveUp();
                    break;
                case KeyboardEvent.KEY_DOWN:
                    painter.moveDown();
                    break;
                case KeyboardEvent.KEY_LEFT:
                    painter.moveLeft();
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    painter.moveRight();
                    break;
                case KeyboardEvent.KEY_L:
                    try {
                        load("resources/test.txt");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case KeyboardEvent.KEY_S:
                    try {
                        save("resources/test.txt");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case KeyboardEvent.KEY_SPACE:
                    spaceHold = true;
                    //TODO: fill the cell
                    break;
            }
        } else {
            switch (event.getKey()) {
                case KeyboardEvent.KEY_SPACE:
                    spaceHold = false;
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        queue.offer(e);

    }

}
