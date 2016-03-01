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

    private static final String[] PATH_REP_FILES = {
            "resources/Buttons/tools/brush.png",
            "resources/Buttons/tools/eraser.png",
            "resources/Buttons/tools/paintbucket.png",
            "resources/Buttons/tools/spray.png",
            "resources/Buttons/tools/rectangle_filled.png",
            "resources/Buttons/tools/rectangle_stroked.png",
            "resources/Buttons/tools/circle_filled.png",
            "resources/Buttons/tools/circle_stroked.png"
    };

    private static final String[] PATH_REP_SELECTED_FILES = {
            "resources/Buttons/tools/brush_s.png",
            "resources/Buttons/tools/eraser_s.png",
            "resources/Buttons/tools/paintbucket_s.png",
            "resources/Buttons/tools/spray_s.png",
            "resources/Buttons/tools/rectangle_filled_s.png",
            "resources/Buttons/tools/rectangle_stroked_s.png",
            "resources/Buttons/tools/circle_filled_s.png",
            "resources/Buttons/tools/circle_stroked_s.png"
    };

    private static final int DEFAULT_TOOLS_PER_LINE = 2;
    private int colOffSet;
    private int rowOffSet;
    private ToolButton[][] toolButtons;
    private ToolButton activeButton;

    public ToolPicker(RepresentationFactory factory, int colOffset, int rowOffSet) {
        this.colOffSet = colOffset;
        this.rowOffSet = rowOffSet;
        init(factory, DEFAULT_TOOLS_PER_LINE);
        this.activeButton = toolButtons[0][0]; //brush
        showActiveButtonRep();
    }


    public Toolable getActiveTool() {
        return activeButton.getToolable();
    }

    public void setActiveButton(int col, int row) {

        resetActiveButtonRep();
        this.activeButton = toolButtons[row - rowOffSet][col - colOffSet];
        showActiveButtonRep();
    }

    private void resetActiveButtonRep() {
        this.activeButton.getRepresentSelected().delete();
        this.activeButton.getRepresentNormal().draw();
    }

    private void showActiveButtonRep() {
        this.activeButton.getRepresentNormal().delete();
        this.activeButton.getRepresentSelected().draw();
    }


    private void init(RepresentationFactory factory, int numberOfToolsPerLine) {

        int rows = ToolType.values().length / numberOfToolsPerLine;
        int cols = numberOfToolsPerLine;

        toolButtons = new ToolButton[rows][cols];

        int toolIndex = 0;

        Representable representation = null;
        Representable representation_selected = null;

        for (int i = 0; i < toolButtons.length; i++) {

            for (int j = 0; j < toolButtons[i].length; j++) {

                representation_selected = factory.getButtonPicture(colOffSet + j, rowOffSet + i, PATH_REP_SELECTED_FILES[toolIndex]);
                representation = factory.getButtonPicture(colOffSet + j, rowOffSet + i, PATH_REP_FILES[toolIndex]);

                representation.draw();

                toolButtons[i][j] = new ToolButton(ToolFactory.getTool(ToolType.values()[toolIndex]));
                toolButtons[i][j].setRepresentSelected(representation_selected);
                toolButtons[i][j].setRepresentNormal(representation);

                toolIndex++;
            }
        }
    }


    public Toolable getTool(int col, int row) {

        return toolButtons[row - rowOffSet][col - colOffSet].getToolable();
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
        return toolButtons.length + rowOffSet;
    }

}
