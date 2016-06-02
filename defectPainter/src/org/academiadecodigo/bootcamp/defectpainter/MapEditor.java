package org.academiadecodigo.bootcamp.defectpainter;

import org.academiadecodigo.bootcamp.defectpainter.menu.Menu;
import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.menu.tools.*;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cursor;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Controller;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Streamer;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.bootcamp.defectpainter.mouse.*;


import java.io.*;
import java.net.URISyntaxException;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MapEditor {

    public static final int DEFAULT_GRID_SIZE = 30;
    private static final int TOP_CORRECTION = 23;
    private static ColorCorrelation activeColor = ColorCorrelation.BLACK;
    private RepresentationFactory factory;
    private Grid grid;
    private Cursor cursor;
    private Controller controller;
    private Menu menu;
    private boolean spaceHold;

    // loop stop condition
    private boolean notOver = true;


    private String path;
    private String fileName;

    /**
     * Constructor
     *
     * @param factory object factory
     */
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

    public static ColorCorrelation getActiveColor() {
        return activeColor;
    }

    public static void setActiveColor(ColorCorrelation activeColor) {
        MapEditor.activeColor = activeColor;
    }

    // Initialize mapEditor components
    private void initCommon() {
        this.cursor = new Cursor(factory, grid.getWidth(), grid.getHeight());
        this.controller = new Controller();
        this.menu = new Menu(factory, grid.getWidth() + 1);

        try {
            this.path = MapEditor.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        path = path.substring(0, path.lastIndexOf("/"));
        fileName = "/myVerySpecialDrawing.txt";
    }

    /**
     * Starts project animation
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (notOver) {

            Thread.sleep(10);

            pollKeyboardEvents();

            pollMouseEvents();
        }

        System.exit(0);
    }


    // checks if the space key is held down to paint or not
    public void continuousPainting() {
        if (spaceHold) {
            if (menu.getActiveTool() instanceof OneClickable) {
                ((OneClickable) menu.getActiveTool()).onClick(this.grid.getCell(cursor.getCol(), cursor.getRow()));
            }
        }
    }

    /**
     * Take keyboardEvents from the LinkedList
     */
    public void pollKeyboardEvents() {

        KeyboardEvent event = controller.keyboardPoll();

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
                    load();
                    break;
                case KeyboardEvent.KEY_S:
                    save();
                    break;
                case KeyboardEvent.KEY_SPACE:
                    if (menu.getActiveTool() instanceof OneClickable) {
                        ((OneClickable) menu.getActiveTool()).onClick(this.grid.getCell(cursor.getCol(), cursor.getRow()));
                    }
                    spaceHold = true;
                    break;
                case KeyboardEvent.KEY_C:
                    cursor.setOn(!cursor.isOn());
                    break;
                case KeyboardEvent.KEY_X:
                    notOver = false;
                    break;
                case KeyboardEvent.KEY_N:
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

    /**
     * Saves the current grid in a file:
     *
     * If running on a jar -> @fileName on the same directory as the jar file
     * If running on the IDE -> defectPainter/out/production/defectPainter/myVerySpecialDrawing.txt file
     */
    public void save() {

        try {
            //Streamer.save(this.grid.convertToCharArray(), "resources/saved_files/therealone.txt");
            Streamer.save(this.grid.convertToCharArray(), path, fileName);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * Loads file from where it was saved.
     * @see MapEditor save()
     */
    public void load() {

        try {
            //this.grid.convertFromCharArray(Streamer.load("resources/saved_files/test.txt"));
            this.grid.convertFromCharArray(Streamer.load(path+fileName));
            resetSections();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void resetSections() {
        cursor.delete();
        cursor = new Cursor(factory, grid.getWidth(), grid.getHeight());

        menu.delete();
        this.menu = new Menu(factory, grid.getWidth() + 1);
    }

    public void pollMouseEvents() {

        MouseEvent event = controller.mousePoll();

        if (event == null) {
            return;
        }

        // gets the col and row from the mouse click
        int tempCol = Converter.xToCol((int) (event.getX() - Converter.LEFT_MARGIN));
        int tempRow = Converter.yToRow((int) (event.getY() - TOP_CORRECTION - Converter.TOP_MARGIN));

        // checks if the click is inside the grid
        if (tempCol > grid.getWidth() - 1 || tempRow > grid.getHeight() - 1 ||
                event.getX() < Converter.LEFT_MARGIN || event.getY() < Converter.TOP_MARGIN + TOP_CORRECTION) {

            // or inside the menu
            if (tempCol > grid.getWidth() && tempCol < menu.getWidth() && tempRow < menu.getHeight() &&
                    event.getY() > Converter.TOP_MARGIN + TOP_CORRECTION) {

                // and if inside menu, asks menu to check what to do
                this.menu.checkAction(this.grid, tempCol, tempRow);

            }

            return;
        }

        // moves cursor to mouse position
        this.cursor.moveTo(tempCol, tempRow);


        switch (event.getEventType()) {
            case MOUSE_CLICKED:
                if (menu.getActiveTool() instanceof OneClickable) {
                    ((OneClickable) menu.getActiveTool()).onClick(this.grid.getCell(cursor.getCol(), cursor.getRow()));
                }
                break;
            case MOUSE_MOVED:
                break;
            case MOUSE_PRESSED:
                if (menu.getActiveTool() instanceof PressReleasable) {
                    ((PressReleasable) menu.getActiveTool()).onPress(this.grid.getCell(cursor.getCol(), cursor.getRow()));
                }
                break;
            case MOUSE_RELEASED:
                if (menu.getActiveTool() instanceof PressReleasable) {
                    ((PressReleasable) menu.getActiveTool()).onRelease(this.grid.getCell(cursor.getCol(), cursor.getRow()), this.grid);
                }
                break;
            case MOUSE_ENTERED:
                break;
            case MOUSE_EXITED:
                break;
            case MOUSE_DRAGGED:
                if (menu.getActiveTool() instanceof OneClickable) {
                    ((OneClickable) menu.getActiveTool()).onClick(this.grid.getCell(cursor.getCol(), cursor.getRow()));
                }
                break;
        }
    }
}

