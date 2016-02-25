package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.Converter;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Fillable;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by milena on 25/02/16.
 */
public class PainterGfx extends Representation {

    public PainterGfx(int col, int row) {
        super.setShape(new Rectangle(Converter.colToX(col) + Converter.LEFT_MARGIN, Converter.rowToY(row) + Converter.TOP_MARGIN,
                Converter.COL_WIDTH, Converter.ROW_HEIGHT));
        super.setColor(Color.BLUE);
        super.fill();
    }

    public void move(int incrementCol, int incrementRow) {

        if (super.getShape() instanceof Movable) {
            ((Movable) super.getShape()).translate(Converter.colToX(incrementCol), Converter.rowToY(incrementRow));
        }
    }


}
