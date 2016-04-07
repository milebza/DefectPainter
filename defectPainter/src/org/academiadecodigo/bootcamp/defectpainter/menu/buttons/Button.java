package org.academiadecodigo.bootcamp.defectpainter.menu.buttons;

import org.academiadecodigo.bootcamp.defectpainter.objects.Representable;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public abstract class Button {

    private Representable representNormal;
    private Representable representSelected;

    public Representable getRepresentNormal() {
        return representNormal;
    }

    public void setRepresentNormal(Representable representNormal) {
        this.representNormal = representNormal;
    }

    public Representable getRepresentSelected() {
        return representSelected;
    }

    public void setRepresentSelected(Representable representSelected) {
        this.representSelected = representSelected;
    }

}
