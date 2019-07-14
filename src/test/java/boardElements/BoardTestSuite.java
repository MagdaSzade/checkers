package boardElements;

import org.junit.Test;

import consoleMode.BoardConsoleMode.BoardConsoleDisplay;

public class BoardTestSuite {
	
	@Test
	public void testDisplay() {
		Board board = new Board();
		board.setInitalBoard();
		BoardConsoleDisplay display = new BoardConsoleDisplay();
		display.showBoard(board);
	}
	
}
