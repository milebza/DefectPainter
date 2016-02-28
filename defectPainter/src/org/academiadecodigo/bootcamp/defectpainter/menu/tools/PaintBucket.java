package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.MapEditor;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by filipejorge on 27/02/16.
 */
public class PaintBucket extends Tool implements PressReleasable {

    public PaintBucket() {
        super.setToolType(ToolType.PAINT_BUCKET);
    }


    //check all 8 cells around cell, if one is from a different color than cell go there and check again, recursive
    //will need access to the grid...

    private char startColor;

    @Override
    public void onPress(Cell cell) {
        startColor = cell.getState();
    }

    @Override
    public void onRelease(Cell cell, Grid grid) {
        int col = cell.getCol();
        int row = cell.getRow();

        //first things first! paint this cell.
        cell.setState(MapEditor.getActiveColor().getState());

        List<Cell> cellsAround = new ArrayList<>();
        //an array with only the cells colored using startColor around this cell
        for (int c = 0; c < 3; c++) {
            for (int r = 0; r < 3; r++) {
                int aroundCol = col + (c - 1);
                int aroundRow = row + (r - 1);
                //protect against out of limits
                if ((aroundCol >= 0 && aroundCol <= grid.getWidth() - 1) && (aroundRow >= 0 && aroundRow <= grid.getHeight() - 1)) {

                    Cell aroundCell = grid.getCell(aroundCol, aroundRow);
                    if (aroundCell.getState() == startColor) {
                        cellsAround.add(aroundCell);
                    }

                }
            }
        }

        //recursive exit condition, if there are none to paint,
        //TODO: stack overflow if all the grid is from the same color.
        if (cellsAround.isEmpty()) {
            return;
        }

        //iterate trough array call recursive using the equal cell as arg
        Iterator<Cell> it = cellsAround.iterator();

        while (it.hasNext()) {
            onRelease(it.next(), grid);
        }

    }
}
