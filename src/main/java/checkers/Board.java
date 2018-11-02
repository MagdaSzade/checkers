package checkers;

import java.util.LinkedList;

public class Board {
	LinkedList <BoardRow> board = new LinkedList<BoardRow>();

	public Board() {
		for (int i = 0; i < 8; i ++) {
			this.board.add(new BoardRow());
		}
	}

	public Figure getFigure(int col, int row) {
	    return this.board.get(row).getBoardRow().get(col);
    }

	public void setFigure(int col, int row, Figure figure) {
	    this.board.get(row).setFigure(col, figure);
    }

	public void startDisplay() {
        for (int row = 0; row < board.size(); row++) {
            if (row == 0 || row == 2) {
                for (int col = 0; col < this.board.get(row).getBoardRow().size(); col = col + 2) {
                    this.board.get(row).setFigure(col, new Pawn(FigureColour.WHITE));
                }
            } else if (row == 1) {
                for (int col = 1; col < this.board.get(row).getBoardRow().size(); col = col + 2) {
                    this.board.get(row).setFigure(col, new Pawn(FigureColour.WHITE));
                }
            } else if (row == 5 || row ==7) {
                for (int col = 1; col < this.board.get(row).getBoardRow().size(); col = col + 2) {
                    this.board.get(row).setFigure(col, new Pawn(FigureColour.BLACK));
                }
            } else if (row == 6) {
                for (int col = 0; col < this.board.get(row).getBoardRow().size(); col = col + 2) {
                    this.board.get(row).setFigure(col, new Pawn(FigureColour.BLACK));
                }
            }
        }
	}

	@Override
	public String toString() {
		String toString = "";
		toString += "  ";
		toString += " A  B  C  D  E  F  G  H \n";
		for (int i = 0; i < board.size(); i++) {
			toString += (i+1) + " ";
			toString += board.get(i).toString();
			toString += "\n";
		}
		return toString;
	}

}
