package org.academiadecodigo.bootcamp.defectpainter.objects;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public interface Representable {

    int getCol();

    int getRow();

    void setColor(Color color);

    void fill();

    void draw();

    void delete();
}
