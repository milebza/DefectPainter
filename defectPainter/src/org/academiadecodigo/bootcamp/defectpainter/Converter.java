package org.academiadecodigo.bootcamp.defectpainter;

/**
 * Created by milena on 25/02/16.
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
        return x / COL_WIDTH;
    }

    public static int yToRow(int y) {
        return y / ROW_HEIGHT;
    }

}
