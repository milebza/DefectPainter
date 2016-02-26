package org.academiadecodigo.bootcamp.defectpainter;


import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by milena, filipe, joana, ita on 24/02/16.
 */
public enum ColorCorrelation {

 /*   public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color LIGHT_GRAY = new Color(192, 192, 192);
    public static final Color GRAY = new Color(128, 128, 128);
    public static final Color DARK_GRAY = new Color(64, 64, 64);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color CYAN = new Color(0, 255, 255);
    public static final Color MAGENTA = new Color(255, 0, 255);
    public static final Color YELLOW = new Color(255, 255, 0);
    public static final Color PINK = new Color(255, 175, 175);
    public static final Color ORANGE = new Color(255, 200, 0);*/



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
    WHITE(' ', Color.WHITE);

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
            case ' ':
                colorCorrelation = ColorCorrelation.WHITE;
                break;
            default:
                colorCorrelation = ColorCorrelation.WHITE;
                break;
        }

        return colorCorrelation;
    }

}
