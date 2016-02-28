package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.objects.*;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class RepresentationGfxFactory implements RepresentationFactory {

    @Override
    public Shapeable getCell(int col, int row, CellType cellType) {
        return new CellGfxShape(col, row, cellType);
    }

    @Override
    public Movable getCursor(int col, int row, CellType cellType) {
        return new PainterGfxShape(col, row, cellType);
    }


    @Override
    public Shapeable getColorButton(int col, int row, CellType cellType) {
        return new ButtonGfxShape(col, row, cellType);
    }

    @Override
    public Representable getButtonPicture(int col, int row, String file) {
        return new ButtonGfxPicture(col, row, file);
    }
}
