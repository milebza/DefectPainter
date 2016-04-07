package org.academiadecodigo.bootcamp.defectpainter.menu.buttons;

import org.academiadecodigo.bootcamp.defectpainter.menu.tools.Toolable;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class ToolButton extends Button {

    private Toolable toolable;

    public ToolButton(Toolable toolable) {
        this.toolable = toolable;
    }

    public Toolable getToolable() {
        return toolable;
    }

}
