package org.academiadecodigo.bootcamp.defectpainter.menu;

import org.academiadecodigo.bootcamp.defectpainter.menu.buttons.ToolButton;
import org.academiadecodigo.bootcamp.defectpainter.menu.tools.ToolFactory;
import org.academiadecodigo.bootcamp.defectpainter.menu.tools.ToolType;
import org.academiadecodigo.bootcamp.defectpainter.menu.tools.Toolable;
import org.academiadecodigo.bootcamp.defectpainter.objects.Representable;
import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class ToolPicker {

    private static final int DEFAULT_TOOLS_PER_LINE = 2;
    private int colOffSet;
    private int rowOfSet;
    private ToolButton[][] toolButtons;

    //TODO: colOffSet and rowOffSet must be checked accordingly all other stuff in menu!!!
    public ToolPicker(RepresentationFactory factory, int colOffset, int rowOffSet) {
        this.colOffSet = colOffset;
        this.rowOfSet = rowOffSet;
        init(factory, DEFAULT_TOOLS_PER_LINE);
    }


    private void init(RepresentationFactory factory, int numberOfToolsPerLine) {

        int rows = ToolType.values().length / numberOfToolsPerLine;
        int cols = numberOfToolsPerLine;

        String[] pathFiles = {"resources/brush.png", "resources/brush.png", "resources/brush.png", "resources/brush.png",
                "resources/brush.png", "resources/brush.png", "resources/brush.png", "resources/brush.png"};

        toolButtons = new ToolButton[rows][cols];

        int toolIndex = 0;

        Representable representation = null;

        for (int i = 0; i < toolButtons.length; i++) {

            for (int j = 0; j < toolButtons[i].length; j++) {

                representation = factory.getButtonPicture(colOffSet + j, rowOfSet + i, pathFiles[toolIndex]);

                toolButtons[i][j] = new ToolButton(ToolFactory.getTool(ToolType.values()[toolIndex]));
                toolButtons[i][j].setRepresentNormal(representation);
                toolButtons[i][j].setRepresentSelected(representation);

                toolIndex++;

            }

        }

    }


    public Toolable getTool(int col, int row) {

        return toolButtons[row - rowOfSet][col - colOffSet].getToolable();
    }


    public void delete() {
        for (int i = 0; i < toolButtons.length; i++) {

            for (int j = 0; j < toolButtons[i].length; j++) {
                //kill both representations
                toolButtons[i][j].getRepresentNormal().delete();
                toolButtons[i][j].getRepresentSelected().delete();
            }
        }
    }


    public int getWidth() {
        return toolButtons[0].length + colOffSet;
    }

    public int getHeight() {
        return toolButtons.length + rowOfSet;
    }

}
