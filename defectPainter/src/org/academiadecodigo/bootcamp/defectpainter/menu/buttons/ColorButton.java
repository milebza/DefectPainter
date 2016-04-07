package org.academiadecodigo.bootcamp.defectpainter.menu.buttons;

import org.academiadecodigo.bootcamp.defectpainter.menu.colors.ColorCorrelation;
import org.academiadecodigo.bootcamp.defectpainter.objects.Representable;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class ColorButton extends Button {

    private ColorCorrelation colorCorrelation;

    public ColorButton(ColorCorrelation colorCorrelation, Representable representable) {
        super.setRepresentNormal(representable);
        super.setRepresentSelected(representable);
        this.colorCorrelation = colorCorrelation;

    }

    public ColorCorrelation getColorCorrelation() {
        return colorCorrelation;
    }

    public void delete() {
        this.getRepresentNormal().delete();
        this.getRepresentSelected().delete();
    }
}
