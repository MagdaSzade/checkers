package checkers;

import java.util.LinkedList;

public class Board {
	LinkedList <BoardRow> board = new LinkedList<BoardRow>();

	public Board() {
		for (int i = 0; i < 8; i ++) {
			this.board.add(new BoardRow());
		}
	}

	public Figure getFigure(String position) {
		int col = this.getColumn(position);
		int row = this.getRow(position);
		return this.board.get(row).getBoardRow().get(col);
    }

	public void setFigure(String position, Figure figure) {
		int col = this.getColumn(position);
		int row = this.getRow(position);
		this.board.get(row).setFigure(col, figure);
    }

	public void removeFigure(String position) {
		int col = this.getColumn(position);
		int row = this.getRow(position);
		this.board.get(row).removeFigure(col, new None());
	}

    public void move(String positionBeg, String positionEnd) {
		Figure moved = this.getFigure(positionBeg);
		if (moved.getGraph() == " ") {
			System.out.println("W rządanym miejscu nie znajduje się figura.");
		} else if (moved.getGraph() == "Q"){
			this.moveQeen(positionBeg, positionEnd);
		} else if (moved.getGraph() == "p") {
			if (moved.getColour() == FigureColour.WHITE) {
				int direction = 0;
				this.movePawn(positionBeg, positionEnd, direction);
			} else if (moved.getColour() == FigureColour.BLACK) {
				int direction = 1;
				this.movePawn(positionBeg, positionEnd, direction);
			}
		}
	}

	private void moveQeen(String positionBeg, String positionEnd) {

	}

	private void movePawn(String positionBeg, String positionEnd, int direction) {
		int columnBeg = this.getColumn(positionBeg);
		int rowBeg = this.getRow(positionBeg);
		int columnEnd = this.getColumn(positionEnd);
		int rowEnd = this.getRow(positionEnd);
		Figure toMove = this.getFigure(positionBeg);

		// moving down - white;
		if (direction == 0) {
			if ( ((columnBeg == columnEnd + 1) || (columnBeg == columnEnd - 1)) && (rowBeg == rowEnd - 1)) {
				if (this.getFigure(positionEnd).getGraph() == " ") {
					this.removeFigure(positionBeg);
					this.setFigure(positionEnd, toMove);
				}
			}
		}
	}

	public void initialLayout() {
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

	private int getColumn(String position) {
		int col;
		switch (position.charAt(0)) {
			case 'A' : col = 0; break;
			case 'B' : col = 1; break;
			case 'C' : col = 2; break;
			case 'D' : col = 3; break;
			case 'E' : col = 4; break;
			case 'F' : col = 5; break;
			case 'G' : col = 6; break;
			case 'H' : col = 7; break;
			default : col = 100; break;
		}
		return col;
	}

	private int getRow(String position) {
		int row;
		switch (position.charAt(1)) {
			case '1' : row = 0; break;
			case '2' : row = 1; break;
			case '3' : row = 2; break;
			case '4' : row = 3; break;
			case '5' : row = 4; break;
			case '6' : row = 5; break;
			case '7' : row = 6; break;
			case '8' : row = 7; break;
			default : row = 100; break;
		}
		return row;
	}
}
