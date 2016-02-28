package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;

/**
 * Created by filipejorge on 27/02/16.
 */
public class CircleFilled extends Tool implements PressReleasable {
    public CircleFilled() {
        super.setToolType(ToolType.CIRCLE_FILLED);
    }

    @Override
    public void onPress(Cell cell) {

    }

    @Override
    public void onRelease(Cell cell, Grid grid) {

    }
}
