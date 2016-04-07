package org.academiadecodigo.bootcamp.defectpainter.utility_classes;

/**
 * Created by milena, filipe, joana, ita on 25/02/16.
 */
public class Converter {

    public static final int TOP_MARGIN = 10;
    public static final int LEFT_MARGIN = 10;

    public static final int COL_WIDTH = 30;
    public static final int ROW_HEIGHT = 30;

    public static int colToX(int col) {
        return col * COL_WIDTH;
    }

    public static int rowToY(int row) {
        return row * ROW_HEIGHT;
    }

    /**
     * Converts the position in the y axis to a column number
     * @param x position in the y axis
     * @return the number of the column associated with that param
     */
    public static int xToCol(int x) {
        return x / COL_WIDTH;
    }

    /**
     * Converts the position in the y axis to a row number
     * @param y position in the y axis
     * @return the number of the row associated with that param
     */
    public static int yToRow(int y) {
        return y / ROW_HEIGHT;
    }

}
