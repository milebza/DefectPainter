package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.bootcamp.defectpainter.objects.Representable;
import org.academiadecodigo.simplegraphics.graphics.Colorable;
import org.academiadecodigo.simplegraphics.graphics.Fillable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public abstract class RepresentationGfx implements Representable {

    private Shape shape;

    public void setShape(Shape shape, char color) {
        this.shape = shape;
        setColor(color);
        shape.draw();
    }

    public Shape getShape() {
        return shape;
    }

    public void setColor(char color) {

        ColorCorrelation c = ColorCorrelation.converter(color);

        if (shape instanceof Colorable) {
            ((Colorable) shape).setColor(c.getColor());
        }
    }

    public void fill() {

        if (shape instanceof Fillable) {
            ((Fillable) shape).fill();
        }
    }

    @Override
    public void delete() {
        shape.delete();
    }

    public void draw() {
        shape.draw();
    }

    @Override
    public int getCol() {
        return Converter.xToCol(shape.getX());
    }

    @Override
    public int getRow() {
        return Converter.yToRow(shape.getY());
    }
}
