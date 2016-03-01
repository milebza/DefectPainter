package org.academiadecodigo.bootcamp.defectpainter.menu;

import org.academiadecodigo.bootcamp.defectpainter.menu.buttons.ToolButton;
import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.menu.tools.Toolable;
import org.academiadecodigo.bootcamp.defectpainter.objects.*;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */

public class Menu {

    private static final int SECTION_MARGIN = 1; // margin between sections in menu

    private ColorPicker colorPicker;
    private Cell[] selectedColor;

    private ToolPicker toolPicker;

    public Menu(RepresentationFactory factory, int colOffset) {

        initColorPicker(factory, colOffset);

        initCurrentColorSection(factory, colOffset);

        initToolPicker(factory, colOffset, colorPicker.getHeight() + SECTION_MARGIN * 3);

    }

    public void initToolPicker(RepresentationFactory representationFactory, int colOffSet, int rowOffSet) {

        this.toolPicker = new ToolPicker(representationFactory, colOffSet, rowOffSet);
    }


    private void initColorPicker(RepresentationFactory factory, int colOffset) {
        this.colorPicker = new ColorPicker(factory, colOffset);
    }

    private void initCurrentColorSection(RepresentationFactory factory, int colOffset) {
        Shapeable cellRepresentation = null;
        this.selectedColor = new Cell[colorPicker.getWidth() - colOffset];

        for (int i = 0; i < selectedColor.length; i++) {
            cellRepresentation = factory.getCell(colOffset + i, colorPicker.getHeight() + SECTION_MARGIN, CellType.RECTANGULAR);
            selectedColor[i] = new Cell(colOffset + i, colorPicker.getHeight() + SECTION_MARGIN, cellRepresentation);
            selectedColor[i].setState(ColorCorrelation.BLACK.getState());
        }


    }


    public void checkAction(Grid grid, int col, int row) {

        if (col < colorPicker.getWidth() && row < colorPicker.getHeight()) {

            // get current color colorCorrelation
            ColorCorrelation colorCorrelation = ColorCorrelation.converter(colorPicker.getColor(col - grid.getWidth() - 1, row));

            // change current color to paint in grid
            grid.setColorCorrelation(colorCorrelation);

            // change current color cells to current color
            for (int i = 0; i < selectedColor.length; i++) {
                selectedColor[i].setState(colorCorrelation.getState());
            }

        } else if (col < toolPicker.getWidth() && row < toolPicker.getHeight()) {


//            setActiveButton(toolPicker.getTool(col, row));
            toolPicker.setActiveButton(col, row);

            //just to see on terminal the activeTool
            //System.out.println(getActiveTool());

        }

    }


    public Toolable getActiveTool() {
        return toolPicker.getActiveTool();
    }


    public void delete() {
        colorPicker.delete();
        toolPicker.delete();

        for (int i = 0; i < selectedColor.length; i++) {
            selectedColor[i].delete();
        }
    }

    public int getWidth() {
        return colorPicker.getWidth();
    }

    public int getHeight() {
        return toolPicker.getHeight();
    }

}
