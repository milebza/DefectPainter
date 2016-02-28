package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.MapEditor;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class RectangleStroked extends Tool implements PressReleasable {

    public RectangleStroked() {
        super.setToolType(ToolType.RECTANGLE_STROKED);
    }

    private int startCol;
    private int startRow;

    @Override
    public void onPress(Cell cell) {
        startCol = cell.getCol();
        startRow = cell.getRow();
        cell.setState(MapEditor.getActiveColor().getState());

    }


    @Override
    public void onRelease(Cell cell, Grid grid) {
        int endCol = cell.getCol();
        int endRow = cell.getRow();

        int minC = Math.min(startCol, endCol);
        int maxC = Math.max(startCol, endCol);
        int minR = Math.min(startRow, endRow);
        int maxR = Math.max(startRow, endRow);

        for (int i = minC; i <= maxC; i++) {
            grid.getCell(i, minR).setState(MapEditor.getActiveColor().getState());
        }
        for (int i = minC; i <= maxC; i++) {
            grid.getCell(i, maxR).setState(MapEditor.getActiveColor().getState());
        }
        for (int j = minR; j <= maxR; j++) {
            grid.getCell(minC, j).setState(MapEditor.getActiveColor().getState());
        }
        for (int j = minR; j <= maxR; j++) {
            grid.getCell(maxC, j).setState(MapEditor.getActiveColor().getState());
        }
    }

}

