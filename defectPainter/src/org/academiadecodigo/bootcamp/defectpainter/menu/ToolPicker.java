package org.academiadecodigo.bootcamp.defectpainter.menu;

import org.academiadecodigo.bootcamp.defectpainter.menu.buttons.ToolButton;
import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.menu.tools.ToolFactory;
import org.academiadecodigo.bootcamp.defectpainter.menu.tools.ToolType;
import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;
import org.academiadecodigo.bootcamp.defectpainter.objects.CellType;
import org.academiadecodigo.bootcamp.defectpainter.objects.Representable;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;

/**
 * Created by Joana Falcão on 28/02/16
 */
public class ToolPicker {

    private static final int DEFAULT_TOOLS_PER_LINE = 2;
    private int col;
    private int row;
    private ToolButton[][] toolButtons;


    public ToolPicker(RepresentationFactory factory, int colOffset, int rowOffSet) {
        this.col = colOffset;
        this.row = rowOffSet;
        init(factory, DEFAULT_TOOLS_PER_LINE);
    }


    private void init(RepresentationFactory factory, int numberOfToolsPerLine) {

        int rows = ToolType.values().length / numberOfToolsPerLine;
        int cols = numberOfToolsPerLine;

        toolButtons = new ToolButton[rows][cols];

        int toolIndex = 0;

        Representable representation = null;

        for (int i = 0; i < toolButtons.length; i++) {

            for (int j = 0; j < toolButtons[i].length; j++) {

                representation = factory.getCell(col + j, row + i, CellType.RECTANGULAR);

                representation.setColor(ColorCorrelation.BLACK.getState());

                toolButtons[i][j] = new ToolButton(ToolFactory.getTool(ToolType.values()[toolIndex]));

                toolButtons[i][j].setRepresentNormal(representation);

                toolIndex++;

            }

        }

    }

}
