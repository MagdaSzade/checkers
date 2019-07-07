package checkers;

import consoleMode.BoardConsoleMode.Board;
import figures.FigureColour;

import java.util.Scanner;

public class Engine {
    private Player player1;
    private Player player2;
    private final boolean playAgainstHuman;
    private boolean gameOn;


    public Engine(String gameMode) {
            this.playAgainstHuman = gameMode;
    }

    public void initializeGame(String initialData) {
    }

    public void game(Scanner command) {

    }

    public void setPlayer1Turn(boolean turn) {
        this.player1.setTurn(turn);
    }

    public void setPlayer2Turn(boolean turn) {
        this.player2.setTurn(turn);
    }

    public boolean getPlayer1Turn() {
        return this.player1.getTurn();
    }

    public boolean getPlayer2Turn() {
        return this.player2.getTurn();
    }

	public static void main(String[] args) {
		figures.Figure;
	}
}
