package org.academiadecodigo.bootcamp.defectpainter.simple_graphics;

import org.academiadecodigo.bootcamp.defectpainter.objects.CellType;
import org.academiadecodigo.bootcamp.defectpainter.objects.Representable;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class RepresentationGfxFactory implements RepresentationFactory {

    @Override
    public Representable getCell(int col, int row, CellType cellType) {
        return new CellGfx(col, row, cellType);
    }
}
