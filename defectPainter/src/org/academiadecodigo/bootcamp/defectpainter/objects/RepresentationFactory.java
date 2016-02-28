package org.academiadecodigo.bootcamp.defectpainter.objects;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public interface RepresentationFactory {

    Shapeable getCell(int col, int row, CellType cellType);

    Movable getCursor(int col, int row, CellType cellType);

    Shapeable getColorButton(int col, int row, CellType cellType);

    Representable getButtonPicture(int col, int row, String file);

}
