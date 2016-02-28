package org.academiadecodigo.bootcamp.defectpainter.objects;


/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public interface Representable {

    int getCol();

    int getRow();

    void setColor(char color);

    void fill();

    void draw();

    void delete();
}
