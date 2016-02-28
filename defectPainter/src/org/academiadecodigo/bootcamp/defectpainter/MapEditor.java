package org.academiadecodigo.bootcamp.defectpainter;

import org.academiadecodigo.bootcamp.defectpainter.menu.Menu;
import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.menu.tools.*;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cursor;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;
import org.academiadecodigo.bootcamp.defectpainter.menu.MenuPanel;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Controller;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Streamer;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.bootcamp.defectpainter.mouse.*;


import java.io.*;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MapEditor {

    public static final int DEFAULT_GRID_SIZE = 30;
    private static final int TOP_CORRECTION = 23;
    private static Toolable activeTool = new Brush();
    private static ColorCorrelation activeColor = ColorCorrelation.BLACK;
    private RepresentationFactory factory;
    private Grid grid;
    private Cursor cursor;
    private Controller controller;
    private MenuPanel menuPanel;
    private Menu menu;
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
        this.cursor = new Cursor(grid.getWidth(), grid.getHeight());
        this.controller = new Controller();
        //this.menuPanel = new MenuPanel(factory, grid.getWidth() + 1);
        this.menu = new Menu(factory, grid.getWidth() + 1);
    }

    public void start() throws InterruptedException {

        while (notOver) {

            Thread.sleep(1);

            pollKeyboardEvents();
            pollMouseEvents();
        }

        System.exit(0);
    }


    public static void setActiveTool(Toolable tool) {
        activeTool = tool;
    }

    public static Toolable getActiveTool() {
        return activeTool;
    }

    public static ColorCorrelation getActiveColor() {
        return activeColor;
    }

    public static void setActiveColor(ColorCorrelation activeColor) {
        MapEditor.activeColor = activeColor;
    }

    public void continuousPainting() {
        if (spaceHold) {
            if (activeTool instanceof OneClickable) {
                ((OneClickable) activeTool).onClick(this.grid.getCell(cursor.getCol(), cursor.getRow()));
                //this.grid.changeState(cursor.getCol(), cursor.getRow());
            }
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
                    cursor.moveUp();
                    continuousPainting();
                    break;
                case KeyboardEvent.KEY_DOWN:
                    cursor.moveDown();
                    continuousPainting();
                    break;
                case KeyboardEvent.KEY_LEFT:
                    cursor.moveLeft();
                    continuousPainting();
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    cursor.moveRight();
                    continuousPainting();
                    break;
                case KeyboardEvent.KEY_L:
                    try {
                        this.grid = Streamer.load(factory, "resources/test.txt", grid);
                        resetSections();
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
                    if (activeTool instanceof OneClickable) {
                        ((OneClickable) activeTool).onClick(this.grid.getCell(cursor.getCol(), cursor.getRow()));
                        //this.grid.changeState(cursor.getCol(), cursor.getRow());
                    }
                    spaceHold = true;
                    break;
                case KeyboardEvent.KEY_C:
                    cursor.setOn(!cursor.isOn());
                    break;
                case KeyboardEvent.KEY_X:
                    notOver = false;
                    break;
                case KeyboardEvent.KEY_R:
                    grid.reset();
                    break;
                case KeyboardEvent.KEY_T: //cycle trough Tools to test before Tool buttons implemented.
                    switch (activeTool.getToolType()) {
                        case BRUSH:
                            activeTool = new Eraser();
                            System.out.println("KEY_T " + activeTool.getToolType());
                            break;
                        case ERASER:
                            activeTool = new RectangleFilled();
                            System.out.println("KEY_T " + activeTool.getToolType());
                            break;
                        case RECTANGLE_FILLED:
                            activeTool = new RectangleStroked();
                            System.out.println("KEY_T " + activeTool.getToolType());
                            break;
                        case RECTANGLE_STROKED:
                            activeTool = new Brush();
                            System.out.println("KEY_T " + activeTool.getToolType());
                            break;
                    }
                    //TODO:(FILIPE)creating new every time... should have a class Menu, that have Tools Buttons to change activeTool.
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

    private void resetSections() {
        cursor.delete();
        cursor = new Cursor(grid.getWidth(), grid.getHeight());

        menuPanel.delete();
        this.menuPanel = new MenuPanel(factory, grid.getWidth() + 1);

        menu.delete();
        this.menu = new Menu(factory, grid.getWidth() + 1);
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

            if (tempCol > grid.getWidth() && tempCol < menu.getWidth() && tempRow < menu.getHeight() &&
                    event.getY() > Converter.TOP_MARGIN + TOP_CORRECTION) {

                this.menu.checkAction(this.grid, tempCol, tempRow);

            }

            return;
        }

        //Move painter (cursor) to mouse position
        this.cursor.setCol(tempCol);
        this.cursor.setRow(tempRow);

        switch (event.getEventType()) {
            case MOUSE_CLICKED:
                if (activeTool instanceof OneClickable) {
                    ((OneClickable) activeTool).onClick(this.grid.getCell(cursor.getCol(), cursor.getRow()));
                }
                break;
            case MOUSE_MOVED:
                break;
            case MOUSE_PRESSED:
                if (activeTool instanceof PressReleasable) {
                    ((PressReleasable) activeTool).onPress(this.grid.getCell(cursor.getCol(), cursor.getRow()));
                }
                break;
            case MOUSE_RELEASED:
                if (activeTool instanceof PressReleasable) {
                    ((PressReleasable) activeTool).onRelease(this.grid.getCell(cursor.getCol(), cursor.getRow()), this.grid);
                }
                break;
            case MOUSE_ENTERED:
                break;
            case MOUSE_EXITED:
                break;
            case MOUSE_DRAGGED:
                if (activeTool instanceof OneClickable) {
                    ((OneClickable) activeTool).onClick(this.grid.getCell(cursor.getCol(), cursor.getRow()));
                }
                break;

        }


    }

}

