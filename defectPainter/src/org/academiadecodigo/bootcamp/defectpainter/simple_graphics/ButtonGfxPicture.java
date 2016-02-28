package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class ButtonGfxPicture extends PictureRepresentationGfx {

    public ButtonGfxPicture(int col, int row, String file) {
        super.setPicture(new Picture(Converter.colToX(col) + Converter.LEFT_MARGIN, Converter.rowToY(row) + Converter.TOP_MARGIN, file));
    }
}
