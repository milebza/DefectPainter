package org.academiadecodigo.bootcamp.defectpainter.menu.tools;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public abstract class Tool implements Toolable {
    private ToolType toolType;

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }


    @Override
    public String toString() {
        return "Tool{" +
                "toolType=" + toolType +
                '}';
    }
}
