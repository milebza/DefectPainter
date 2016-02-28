package org.academiadecodigo.bootcamp.defectpainter.objects;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public interface RepresentationFactory {

    Representable getCell(int col, int row, CellType cellType);

    Movable getCursor(int col, int row, CellType cellType);

    Representable getColorButton(int col, int row, CellType cellType);

}
