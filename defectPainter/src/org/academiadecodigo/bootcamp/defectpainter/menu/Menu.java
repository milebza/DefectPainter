package org.academiadecodigo.bootcamp.defectpainter.menu;

import org.academiadecodigo.bootcamp.defectpainter.MapEditor;
import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.objects.*;

/**
 * Created by filipejorge on 27/02/16.
 */

//TODO: (FALCAO) this should replace the MenuPanel, right?
public class Menu {

    private static final int SECTION_MARGIN = 1;
    //private ToolButton[] toolButtons;
    private ColorPicker colorPicker;
    private Cell[] selectedColor;

    private ToolPicker toolPicker;

    public Menu(RepresentationFactory factory, int colOffset) {

        //TODO: Separate sections init stuff

        //initTools();

        initColorPicker(factory, colOffset);

        initCurrentColorSection(factory, colOffset);

        //TODO: (FALCAO) colOffSet and rowOffSet must be checked accordingly all other stuff in menu!!!
        initToolPicker(factory, colOffset, colorPicker.getHeight() + SECTION_MARGIN * 3);

    }

    public void initToolPicker(RepresentationFactory representationFactory, int colOffSet, int rowOffSet) {

        this.toolPicker = new ToolPicker(representationFactory, colOffSet, rowOffSet);
    }


    /*public void initTools() {
        toolButtons = new ToolButton[2];

        toolButtons[0] = new ToolButton(new Brush());
        toolButtons[1] = new ToolButton(new Eraser());


    }*/

    private void initColorPicker(RepresentationFactory factory, int colOffset) {
        this.colorPicker = new ColorPicker(factory, colOffset);
    }

    private void initCurrentColorSection(RepresentationFactory factory, int colOffset) {
        Shapeable cellRepresentation = null;
        this.selectedColor = new Cell[colorPicker.getWidth() - colOffset];

        for (int i = 0; i < selectedColor.length; i++) {
            cellRepresentation = factory.getCell(colOffset + i, colorPicker.getHeight() + SECTION_MARGIN, CellType.RECTANGULAR);
            selectedColor[i] = new Cell(colOffset + i, colorPicker.getHeight() + SECTION_MARGIN, cellRepresentation);
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

            MapEditor.setActiveTool(toolPicker.getTool(col, row));

            //just to see on terminal the activeTool
            System.out.println(MapEditor.getActiveTool());

        }

    }

    public void delete() {
        colorPicker.delete();

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
