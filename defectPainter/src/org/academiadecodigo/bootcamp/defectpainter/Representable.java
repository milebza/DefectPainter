package org.academiadecodigo.bootcamp.defectpainter;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by milena on 25/02/16.
 */
public interface Representable {

    int getCol();

    int getRow();

    void setColor(Color color);

    void fill();

    void draw();
}
