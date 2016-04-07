package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.bootcamp.defectpainter.objects.Movable;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class MovableShapeRepresentationGfx extends ShapeRepresentationGfx implements Movable {

    @Override
    public void move(int incrementCol, int incrementRow) {
        if (super.getShape() instanceof org.academiadecodigo.simplegraphics.graphics.Movable) {
            ((org.academiadecodigo.simplegraphics.graphics.Movable) super.getShape()).translate(Converter.colToX(incrementCol), Converter.rowToY(incrementRow));
        }
    }
}
