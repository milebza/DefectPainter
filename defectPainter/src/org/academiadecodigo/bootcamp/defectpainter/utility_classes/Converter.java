package org.academiadecodigo.bootcamp.defectpainter.utility_classes;

/**
 * Created by milena, filipe, joana, ita on 25/02/16.
 */
public class Converter {

    public static final int TOP_MARGIN = 10;
    public static final int LEFT_MARGIN = 10;

    public static final int COL_WIDTH = 50;
    public static final int ROW_HEIGHT = 50;

    public static int colToX(int col) {
        return col * COL_WIDTH;
    }

    public static int rowToY(int row) {
        return row * ROW_HEIGHT;
    }

    public static int xToCol(int x) {
        System.out.println("X " + (x / COL_WIDTH));
        return x / COL_WIDTH;
    }

    public static int yToRow(int y) {
        System.out.println("Y " + (y / ROW_HEIGHT));
        return y / ROW_HEIGHT;
    }

}
