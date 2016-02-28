package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public interface PressReleasable {
    void onPress(Cell cell);

    void onRelease(Cell cell, Grid grid);
}
