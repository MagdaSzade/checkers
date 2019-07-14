package checkers;

import figures.FigureColour;
import boardElements.Player;
import boardElements.Board;
import interfaces.CommunicationWithPlayerInterface;
import interfaces.DisplayInterface;

public class GameEngine {
    private Player player1;
    private Player player2;
    private boolean gameOn;
    private Board board;
    CommunicationWithPlayerInterface communication;
    DisplayInterface display;

    public GameEngine(CommunicationWithPlayerInterface communication, DisplayInterface display) {
    	this.communication = communication;
    	this.display = display;
    	this.board = new Board();
    }
    
    public void initializeGame() {
    	communication.welcomeMassage();
    	FigureColour playerTwoColour = null; 	
    	String player1name = communication.setName("gracz pierwszy");
    	boolean colourBool = communication.setColoure();
    	if (colourBool) {
    		player1 = new Player(player1name, FigureColour.BLACK, true);
    		playerTwoColour = FigureColour.WHITE;
    	} else {
    		player1 = new Player(player1name, FigureColour.WHITE, true);
    		playerTwoColour = FigureColour.BLACK;
    	}
    	if (communication.setOponentType()) {
    		String player2name = communication.setName("gracz drugi");
    		player2 = new Player(player2name, playerTwoColour, true);
    	} else {
    		player2 = new Player("Komputer", playerTwoColour, false);	
    	}
    	board.setInitalBoard();
    }
    
    public void displayBoard() {
    	display.showBoard(board);
    }
    
    
}
