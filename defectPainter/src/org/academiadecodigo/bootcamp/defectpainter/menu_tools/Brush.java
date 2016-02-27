package org.academiadecodigo.bootcamp.defectpainter.menu_tools;

import org.academiadecodigo.bootcamp.defectpainter.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.MapEditor;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.Grid;

/**
 * Created by filipejorge on 27/02/16.
 */
public class Brush extends Tool {

    public Brush() {
        super.setToolType(ToolType.BRUSH);
    }

    @Override
    public void act(Cell cell) {

        cell.setState(MapEditor.getActiveColor().getState());

    }


}
