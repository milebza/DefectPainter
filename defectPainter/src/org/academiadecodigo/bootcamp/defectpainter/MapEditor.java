package org.academiadecodigo.bootcamp.defectpainter;

import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Controller;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Streamer;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;


import java.io.*;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MapEditor {

    public static final int DEFAULT_GRID_SIZE = 100;
    private static final int TOP_CORRECTION = 23;
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

            pollKeyboardEvents();
            pollMouseEvents();
        }
    }


    public void pollKeyboardEvents() {

        KeyboardEvent event = controller.getQueueKeyboard().poll();

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
                    this.grid.changeState(painter.getCol(), painter.getRow());
                    break;
                case KeyboardEvent.KEY_C:
                    painter.setOn(!painter.isOn());
                    break;
            }
        } else { //KEY.RELEASE
            switch (event.getKey()) {
                case KeyboardEvent.KEY_SPACE:
                    spaceHold = false;
                    break;
            }
        }
    }

    public void pollMouseEvents() {
        MouseEvent event = controller.getQueueMouse().poll();

        if (event == null) {
            return;
        }

        int tempCol = Converter.xToCol((int) (event.getX() - Converter.LEFT_MARGIN));
        int tempRow = Converter.yToRow((int) (event.getY() - TOP_CORRECTION - Converter.TOP_MARGIN));
        if (tempCol > grid.getWidth() - 1 || tempRow > grid.getHeight() - 1 || event.getX() < Converter.LEFT_MARGIN || event.getY() < Converter.TOP_MARGIN + TOP_CORRECTION) {
            return;
        }


        if (event.getEventType() == MouseEventType.MOUSE_CLICKED) {

            this.grid.changeState(tempCol, tempRow);
        } /*else { //MOUSE_MOVE
            if (spaceHold) {
                this.grid.changeState(Converter.xToCol((int) event.getX()), Converter.yToRow((int) event.getY() - TOP_CORRECTION));
            }
        }*/

    }
}
