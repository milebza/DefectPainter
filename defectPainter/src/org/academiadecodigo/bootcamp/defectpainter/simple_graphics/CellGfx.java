package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.Converter;
import org.academiadecodigo.bootcamp.defectpainter.Representable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by milena on 25/02/16.
 */
public class CellGfx extends Representation {


    public CellGfx(int col, int row) {
        super.setShape(new Rectangle(Converter.colToX(col) + Converter.LEFT_MARGIN, Converter.rowToY(row) + Converter.TOP_MARGIN,
                Converter.COL_WIDTH, Converter.ROW_HEIGHT));
    }


}
