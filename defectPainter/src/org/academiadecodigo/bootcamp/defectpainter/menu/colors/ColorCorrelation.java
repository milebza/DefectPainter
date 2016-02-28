package org.academiadecodigo.bootcamp.defectpainter.menu.colors;


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
    LIGHT_GRAY('h', Color.LIGHT_GRAY),
    GRAY('G', Color.GRAY),
    DARK_GRAY('H', Color.DARK_GRAY),
    CYAN('c', Color.CYAN),
    MAGENTA('m', Color.MAGENTA),
    PINK('p', Color.PINK),
    BROWN('R', Color.BROWN),
    DARK_GREEN('d', Color.DARK_GREEN),
    AQUAMARINE('a', Color.AQUAMARINE),
    VIOLET('v', Color.VIOLET),
    PURPLE('P', Color.PURPLE),
    PEACH('l', Color.PEACH),
    TURQUOISE('t', Color.TURQUOISE),
    TOMATO('T', Color.TOMATO),
    WHITE('-', Color.WHITE);


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
            case 'h':
                colorCorrelation = ColorCorrelation.LIGHT_GRAY;
                break;
            case 'G':
                colorCorrelation = ColorCorrelation.GRAY;
                break;
            case 'H':
                colorCorrelation = ColorCorrelation.DARK_GRAY;
                break;
            case 'c':
                colorCorrelation = ColorCorrelation.CYAN;
                break;
            case 'm':
                colorCorrelation = ColorCorrelation.MAGENTA;
                break;
            case 'p':
                colorCorrelation = ColorCorrelation.PINK;
                break;
            case 'R':
                colorCorrelation = ColorCorrelation.BROWN;
                break;
            case 'd':
                colorCorrelation = ColorCorrelation.DARK_GREEN;
                break;
            case 'a':
                colorCorrelation = ColorCorrelation.AQUAMARINE;
                break;
            case 'v':
                colorCorrelation = ColorCorrelation.VIOLET;
                break;
            case 'P':
                colorCorrelation = ColorCorrelation.PURPLE;
                break;
            case 'l':
                colorCorrelation = ColorCorrelation.PEACH;
                break;
            case 't':
                colorCorrelation = ColorCorrelation.TURQUOISE;
                break;
            case 'T':
                colorCorrelation = ColorCorrelation.TOMATO;
                break;
            case '-':
                colorCorrelation = ColorCorrelation.WHITE;
                break;
            default:
                colorCorrelation = ColorCorrelation.WHITE;
                break;
        }

        return colorCorrelation;
    }

}
