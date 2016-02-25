package org.academiadecodigo.bootcamp.defectpainter;

import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Controller;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Streamer;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;


import java.io.*;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MapEditor {

    public static final int DEFAULT_GRID_SIZE = 10;
    private Grid grid;
    private Painter painter;
    private boolean spaceHold;
    private Controller controller;


    public MapEditor() {
        this.grid = new Grid(DEFAULT_GRID_SIZE, DEFAULT_GRID_SIZE);
        this.painter = new Painter(grid.getWidth(), grid.getHeight());
        this.controller = new Controller();
    }

    public MapEditor(int w, int h) {
        this.grid = new Grid(w, h);
        this.painter = new Painter(grid.getWidth(), grid.getHeight());
        this.controller = new Controller();
    }

    public MapEditor(String file) throws IOException {
        this.grid = Streamer.load(file, grid);
        this.painter = new Painter(grid.getWidth(), grid.getHeight());
        this.controller = new Controller();
    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(50);

            pollEvents();
        }
    }



    public void pollEvents() {

        KeyboardEvent event = controller.getQueue().poll();

        if (event == null) {
            return;
        }

        if (event.getKeyboardEventType() == KeyboardEventType.KEY_PRESSED) {
            switch (event.getKey()) {
                case KeyboardEvent.KEY_UP:
                    if (spaceHold) {
                        this.grid.changeState(painter.getCol(), painter.getRow());
                    }
                    painter.moveUp();
                    break;
                case KeyboardEvent.KEY_DOWN:
                    if (spaceHold) {
                        this.grid.changeState(painter.getCol(), painter.getRow());
                    }
                    painter.moveDown();
                    break;
                case KeyboardEvent.KEY_LEFT:
                    if (spaceHold) {
                        this.grid.changeState(painter.getCol(), painter.getRow());
                    }
                    painter.moveLeft();
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    if (spaceHold) {
                        this.grid.changeState(painter.getCol(), painter.getRow());
                    }
                    painter.moveRight();
                    break;
                case KeyboardEvent.KEY_L:
                    try {
                        Streamer.load("resources/test.txt", grid);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case KeyboardEvent.KEY_S:
                    try {
                        Streamer.save("resources/test.txt", this.grid);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case KeyboardEvent.KEY_SPACE:
                    spaceHold = true;
                    System.out.println("k_s");
                    this.grid.changeState(painter.getCol(), painter.getRow());
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
}
