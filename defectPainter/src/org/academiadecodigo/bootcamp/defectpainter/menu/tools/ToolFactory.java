package org.academiadecodigo.bootcamp.defectpainter.menu.tools;


/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class ToolFactory {

    public static Toolable getTool(ToolType toolType) {

        Toolable toolable = null;

        switch (toolType) {
            case BRUSH:
                toolable = new Brush();
                break;
            case ERASER:
                toolable = new Eraser();
                break;
            case PAINT_BUCKET:
                toolable = new PaintBucket();
                break;
            case SPRAY:
                toolable = new Spray();
                break;
            case RECTANGLE_FILLED:
                toolable = new RectangleFilled();
                break;
            case RECTANGLE_STROKED:
                toolable = new RectangleStroked();
                break;
            case CIRCLE_FILLED:
                toolable = new CircleFilled();
                break;
            case CIRCLE_STROKED:
                toolable = new CircleStroked();
                break;


        }

        return toolable;

    }


}
