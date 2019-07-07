package checkers;

import consoleMode.BoardConsoleMode.BoardConsoleDisplay;
import figures.Figure;
import figures.FigureColour;

import java.util.LinkedList;

public class Player {

    private final String name;
    private final FigureColour colour;
    private boolean turn;
    private final boolean isHuman;

    public Player(String name, FigureColour colour, boolean isHuman) {
        this.name = name;
        this.colour = colour;
        this.isHuman = isHuman;
    }

    public String getName() {
        return this.name;
    }

    public FigureColour getColour() {
        return this.colour;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getTurn() {
        return this.turn;
    }

    public boolean getIsHuman() {
        return isHuman;
    }
}
