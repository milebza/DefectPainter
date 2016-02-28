package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Eraser extends Tool implements OneClickable {

    public Eraser() {
        super.setToolType(ToolType.ERASER);
    }

    @Override
    public void onClick(Cell cell) {
        cell.setState(ColorCorrelation.WHITE.getState());
    }

}
