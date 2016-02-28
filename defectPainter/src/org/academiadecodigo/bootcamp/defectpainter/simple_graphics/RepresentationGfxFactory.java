package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.objects.CellType;
import org.academiadecodigo.bootcamp.defectpainter.objects.Movable;
import org.academiadecodigo.bootcamp.defectpainter.objects.Representable;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class RepresentationGfxFactory implements RepresentationFactory {

    @Override
    public Representable getCell(int col, int row, CellType cellType) {
        return new CellGfxShape(col, row, cellType);
    }

    @Override
    public Movable getCursor(int col, int row, CellType cellType) {
        return new PainterGfxShape(col, row, cellType);
    }


    @Override
    public Representable getColorButton(int col, int row, CellType cellType) {
        return new ButtonGfxShape();
    }
}
