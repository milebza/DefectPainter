package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;

/**
 * Created by filipejorge on 27/02/16.
 */
public class Spray extends Tool implements OneClickable {

    public Spray() {
        super.setToolType(ToolType.SPRAY);
    }

    @Override
    public void onClick(Cell cell) {

    }
}
