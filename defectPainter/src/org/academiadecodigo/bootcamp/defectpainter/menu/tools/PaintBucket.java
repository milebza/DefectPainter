package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;

/**
 * Created by filipejorge on 27/02/16.
 */
public class PaintBucket extends Tool implements OneClickable {

    public PaintBucket() {
        super.setToolType(ToolType.PAINT_BUCKET);
    }

    @Override
    public void onClick(Cell cell) {

    }
}
