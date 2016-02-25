package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.bootcamp.defectpainter.Representable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Colorable;
import org.academiadecodigo.simplegraphics.graphics.Fillable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by milena on 25/02/16.
 */
public abstract class Representation implements Representable {


    private Shape shape;


    public void setShape(Shape shape) {
        this.shape = shape;
        shape.draw();
    }

    public Shape getShape() {
        return shape;
    }

    public void setColor(Color color) {
        if (shape instanceof Colorable) {
            ((Colorable) shape).setColor(color);
        }
    }

    public void fill() {
        if (shape instanceof Fillable) {
            ((Fillable) shape).fill();
        }
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
