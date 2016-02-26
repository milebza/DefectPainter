package org.academiadecodigo.bootcamp.defectpainter;


import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public enum ColorCorrelation {

    BLUE('b', Color.BLUE),
    BLACK('B', Color.BLACK),
    RED('r', Color.RED),
    GREEN('g', Color.GREEN),
    YELLOW('y', Color.YELLOW),
    ORANGE('o', Color.ORANGE),
    PINK('p', Color.PINK),
    GREY('G', Color.GRAY),
    WITHE(' ', Color.WHITE);

    private char state;
    private Color color;

    ColorCorrelation(char state, Color color) {
        this.state = state;
        this.color = color;
    }

    public char getState() {
        return state;
    }

    public Color getColor() {
        return color;
    }

    public static ColorCorrelation converter(char c) {

        ColorCorrelation colorCorrelation = null;

        switch (c) {
            case 'b':
                colorCorrelation = ColorCorrelation.BLUE;
                break;
            case 'B':
                colorCorrelation = ColorCorrelation.BLACK;
                break;
            case 'r':
                colorCorrelation = ColorCorrelation.RED;
                break;
            case 'g':
                colorCorrelation = ColorCorrelation.GREEN;
                break;
            case 'y':
                colorCorrelation = ColorCorrelation.YELLOW;
                break;
            case 'o':
                colorCorrelation = ColorCorrelation.ORANGE;
                break;
            case 'p':
                colorCorrelation = ColorCorrelation.PINK;
                break;
            case 'G':
                colorCorrelation = ColorCorrelation.GREY;
                break;
            case ' ':
                colorCorrelation = ColorCorrelation.WITHE;
                break;
            default:
                colorCorrelation = ColorCorrelation.WITHE;
                break;
        }

        return colorCorrelation;
    }

}
