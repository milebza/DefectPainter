package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.MapEditor;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;

/**
 * Created by filipejorge on 27/02/16.
 */
public class Spray extends Tool implements PressReleasable {

    public Spray() {
        super.setToolType(ToolType.SPRAY);
    }

    private int centerCol;
    private int centerRow;

    @Override
    public void onPress(Cell cell) {
        centerCol = cell.getCol();
        centerRow = cell.getRow();
    }

    @Override
    public void onRelease(Cell cell, Grid grid) {
        int endCol = cell.getCol();
        int endRow = cell.getRow();
        //find the radius
        int radiusMax = (int) Math.hypot(centerCol - endCol, centerRow - endRow);
        //cycle from 0 to radius
        for (int radius = 0; radius <= radiusMax; radius++) {
            //cycle trough all cell on the radius...
            for (float col = centerCol - radius; col <= centerCol + radius; col = col + 0.1f) {
                //protect from index out of bounds.
                if (col > 0 && col < grid.getWidth() - 1) {
                    double c1 = Math.pow(radius, 2);
                    double c2 = Math.pow(centerCol - col, 2);
                    double hypot = Math.sqrt(c1 - c2);
                    int row = (int) Math.round(hypot);
                    int rowUp = centerRow + row;
                    int rowDown = centerRow - row;
                    //protect from index out of bounds.
                    if (rowUp >= 0 && rowUp <= grid.getHeight() - 1) {
                        if (Math.random() > 0.9f) {
                            grid.getCell(Math.round(col), rowUp).setState(MapEditor.getActiveColor().getState());
                        }
                    }
                    if (rowDown >= 0 && rowDown <= grid.getHeight() - 1) {
                        if (Math.random() > 0.9f) {
                            grid.getCell(Math.round(col), rowDown).setState(MapEditor.getActiveColor().getState());
                        }
                    }
                }
            }
        }
    }
}
