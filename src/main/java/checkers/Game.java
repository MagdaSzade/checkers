package checkers;

import consoleMode.BoardConsoleMode.BoardConsoleDisplay;
import consoleMode.CommunicationWithPlayerConsoleMode.CommunicationWithThePlayer;
import figures.FigureColour;
import figures.Pawn;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
			
		BoardConsoleDisplay board = new BoardConsoleDisplay();
		CommunicationWithThePlayer communication = new CommunicationWithThePlayer();
		GameEngine gameEngine = new GameEngine(communication, board);
		boolean isGameOn = true;
		
		gameEngine.initializeGame();
		while (isGameOn) {
			
		}
	}

}
