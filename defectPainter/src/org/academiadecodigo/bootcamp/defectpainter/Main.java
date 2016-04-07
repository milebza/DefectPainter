package org.academiadecodigo.bootcamp.defectpainter;


import org.academiadecodigo.bootcamp.defectpainter.objects.RepresentationFactory;
import org.academiadecodigo.bootcamp.defectpainter.simple_graphics.RepresentationGfxFactory;
import org.academiadecodigo.bootcamp.defectpainter.utility_classes.Converter;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Represent the grid with baby blue rectangles
        Rectangle background = new Rectangle(Converter.TOP_MARGIN, Converter.LEFT_MARGIN, Converter.COL_WIDTH * (MapEditor.DEFAULT_GRID_SIZE + 3), Converter.ROW_HEIGHT * MapEditor.DEFAULT_GRID_SIZE);
        background.setColor(new Color(230, 250, 255));
        background.fill();
        RepresentationFactory factory = new RepresentationGfxFactory();

        MapEditor mapEditor = null;
        mapEditor = new MapEditor(factory);

        mapEditor.start();

    }
}
