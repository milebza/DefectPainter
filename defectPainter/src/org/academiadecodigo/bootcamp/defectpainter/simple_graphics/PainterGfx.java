package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class PainterGfx extends MovableRepresentationGfx {

    public PainterGfx(int col, int row) {
        super.setShape(new Rectangle(Converter.colToX(col) + Converter.LEFT_MARGIN, Converter.rowToY(row) + Converter.TOP_MARGIN,
                Converter.COL_WIDTH, Converter.ROW_HEIGHT), Color.PINK);


    }


}
