package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.MapEditor;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Brush extends Tool implements OneClickable {

    public Brush() {
        super.setToolType(ToolType.BRUSH);
    }

    @Override
    public void onClick(Cell cell) {
        cell.setState(MapEditor.getActiveColor().getState());
    }
}
