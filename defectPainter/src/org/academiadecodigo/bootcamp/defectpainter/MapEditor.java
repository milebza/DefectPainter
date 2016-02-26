package org.academiadecodigo.bootcamp.defectpainter;

import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;
import org.academiadecodigo.bootcamp.defectpainter.objects.MenuPanel;
import org.academiadecodigo.bootcamp.defectpainter.objects.Painter;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;
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

    public static final int DEFAULT_GRID_SIZE = 30;
    private static final int TOP_CORRECTION = 23;
    private RepresentationFactory factory;
    private Grid grid;
    private Painter painter;
    private Controller controller;
    private MenuPanel menuPanel;
    private boolean spaceHold;

    private boolean notOver = true;


    public MapEditor(RepresentationFactory factory) {
        this.factory = factory;
        this.grid = new Grid(factory, DEFAULT_GRID_SIZE, DEFAULT_GRID_SIZE);
        initCommon();
    }

    public MapEditor(RepresentationFactory factory, int w, int h) {
        this.factory = factory;
        this.grid = new Grid(factory, w, h);
        initCommon();
    }

    public MapEditor(RepresentationFactory factory, String file) throws IOException {
        this.factory = factory;
        this.grid = Streamer.load(factory, file, grid);
        initCommon();
    }

    private void initCommon() {
        this.painter = new Painter(grid.getWidth(), grid.getHeight());
        this.controller = new Controller();
        this.menuPanel = new MenuPanel(factory, grid.getWidth() + 1);
    }

    public void start() throws InterruptedException {

        while (notOver) {

            Thread.sleep(50);

            pollKeyboardEvents();
            pollMouseEvents();
        }

        System.exit(0);
    }


    public void continuousPainting() {
        if (spaceHold) {
            this.grid.changeState(painter.getCol(), painter.getRow());
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
                    painter.moveUp();
                    continuousPainting();
                    break;
                case KeyboardEvent.KEY_DOWN:
                    painter.moveDown();
                    continuousPainting();
                    break;
                case KeyboardEvent.KEY_LEFT:
                    painter.moveLeft();
                    continuousPainting();
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    painter.moveRight();
                    continuousPainting();
                    break;
                case KeyboardEvent.KEY_L:
                    try {
                        this.grid = Streamer.load(factory, "resources/test.txt", grid);
                        resetPainter();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    break;
                case KeyboardEvent.KEY_S:
                    try {
                        Streamer.save("resources/test.txt", this.grid);
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    break;
                case KeyboardEvent.KEY_SPACE:
                    this.grid.changeState(painter.getCol(), painter.getRow());
                    spaceHold = true;
                    break;
                case KeyboardEvent.KEY_C:
                    painter.setOn(!painter.isOn());
                    break;
                case KeyboardEvent.KEY_X:
                    notOver = false;
                    break;
                case KeyboardEvent.KEY_R:
                    grid.reset();
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

    private void resetPainter() {
        painter.delete();
        painter = new Painter(grid.getWidth(), grid.getHeight());
    }

    public void pollMouseEvents() {
        MouseEvent event = controller.getQueueMouse().poll();

        if (event == null) {
            return;
        }

        int tempCol = Converter.xToCol((int) (event.getX() - Converter.LEFT_MARGIN));
        int tempRow = Converter.yToRow((int) (event.getY() - TOP_CORRECTION - Converter.TOP_MARGIN));

        if (tempCol > grid.getWidth() - 1 || tempRow > grid.getHeight() - 1 ||
                event.getX() < Converter.LEFT_MARGIN || event.getY() < Converter.TOP_MARGIN + TOP_CORRECTION) {

            if (tempCol > grid.getWidth() && tempCol < menuPanel.getWidth() && tempRow < menuPanel.getHeight() &&
                    event.getY() > Converter.TOP_MARGIN + TOP_CORRECTION) {

                this.menuPanel.checkAction(this.grid, tempCol, tempRow);

            }

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
