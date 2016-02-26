package org.academiadecodigo.bootcamp.defectpainter.objects;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public interface RepresentationFactory {

    Representable getCell(int col, int row, CellType cellType);

}
