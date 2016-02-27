package org.academiadecodigo.bootcamp.defectpainter.menu_tools;

import org.academiadecodigo.bootcamp.defectpainter.objects.Cell;

/**
 * Created by filipejorge on 27/02/16.
 */
public abstract class Tool {
    private ToolType toolType;

    public abstract void act(Cell cell);

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }
}
