package org.academiadecodigo.bootcamp.defectpainter.menu_tools;

import org.academiadecodigo.bootcamp.defectpainter.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;

/**
 * Created by filipejorge on 27/02/16.
 */
public class Eraser extends Tool {

    public Eraser() {
        super.setToolType(ToolType.ERASER);
    }

    @Override
    public void act(Cell cell) {

        cell.setState(ColorCorrelation.WHITE.getState());

    }

}
