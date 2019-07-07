package consoleMode.BoardConsoleMode;

import boardElements.Board;
import boardElements.Position;
import interfaces.DisplayInterface;

public class BoardConsoleDisplay implements DisplayInterface {
    
	public void showBoard(Board board) {
    	System.out.println(this.toString(board));
    }
    
    public String toString(Board board) {
        String toString = "  A  B  C  D  E  F  G  H \n";
        int colNbr = 8;
        for (int i = 0; i < 8; i++) {
            toString += colNbr + "|";
            for (int j = 0; j < 8; j++) {
                toString += board.getFigure(new Position(i, j)) + "|";
            }
            toString += "\n";
            colNbr--;
        }
        return toString;
    }
}