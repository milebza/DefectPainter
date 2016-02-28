package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.MapEditor;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;

/**
 * Created by filipejorge on 27/02/16.
 */
public class CircleStroked extends Tool implements PressReleasable {
    public CircleStroked() {
        super.setToolType(ToolType.CIRCLE_STROKED);
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
        //find the radius

        //cycle trough all cell on the radius...

    }
}
