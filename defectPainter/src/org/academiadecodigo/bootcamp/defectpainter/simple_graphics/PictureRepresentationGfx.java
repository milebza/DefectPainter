package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.objects.Representable;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */

public class PictureRepresentationGfx implements Representable {
    private Picture picture;

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public int getCol() {
        return Converter.xToCol(picture.getX());
    }

    @Override
    public int getRow() {
        return Converter.yToRow(picture.getY());
    }

    @Override
    public void draw() {
        picture.draw();
    }

    @Override
    public void delete() {
        picture.delete();
    }
}
