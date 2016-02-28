package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.objects.Pictureable;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * @author Filipe Jorge.
 *         At <Academia de Código_> on 28/02/16.
 */

public class PictureRepresentationGfx implements Pictureable {
    private Picture picture;


    public void setPicture(String file) {
        this.picture = picture.load(file);
        picture.draw();
    }


    public Picture getPicture() {
        return picture;
    }

    @Override
    public Picture load(String file) {
        picture.load(file);
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
