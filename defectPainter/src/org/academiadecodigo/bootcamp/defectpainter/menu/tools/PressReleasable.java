package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;

/**
 * Created by filipejorge on 27/02/16.
 */
public interface PressReleasable {
    void onPress(Cell cell);

    void onRelease(Cell cell, Grid grid);
}
