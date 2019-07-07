package boardElements;

import figures.Figure;
import figures.FigureColour;
import figures.None;
import figures.Pawn;

public class Board {
	private Figure[][] board = new Figure[8][8];

    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = new None();
            }
        }
    }

    public void setFigure(Figure figure, Position position) {
        board[position.getColumn()][position.getRow()] = figure;
    }

    public Figure getFigure(Position position) {
        return board[position.getColumn()][position.getRow()];
    }

    public void setInitalBoard() {
        for (int i = 7; i >= 5; i=i-2) {
            for (int j = 0; j < 8; j=j+2) {
                Position position = new Position(i, j);
                Figure pawn = new Pawn(FigureColour.WHITE);
                this.setFigure(pawn, position);
            }
        }
        for (int j = 1; j < 8; j=j+2) {
            Position position = new Position(6, j);
            Figure pawn = new Pawn(FigureColour.WHITE);
            this.setFigure(pawn, position);
        }
        for (int i = 0; i <= 2; i=i+2) {
            for (int j = 1; j < 8; j=j+2) {
                Position position = new Position(i, j);
                Figure pawn = new Pawn(FigureColour.BLACK);
                this.setFigure(pawn, position);
            }
        }
        for (int j = 0; j < 8; j=j+2) {
            Position position = new Position(1, j);
            Figure pawn = new Pawn(FigureColour.BLACK);
            this.setFigure(pawn, position);
        }

    }
    
}


    /*
	public static Board startBoard() {
	    Board board = new Board();
        }
		    }
	    }
	    return
	}

	public Figure getFigure(int col, int row) {
	    return this.board[col][row];
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
		this.board.get(row).removeFigure(col, new None(position));
	}

    public void move(String positionBeg, String positionEnd) {
		Figure moved = this.getFigure(positionBeg);

		if (moved.isEmpty()) {
			System.out.println("W rządanym miejscu nie znajduje się figura.");
		} else if (!this.getFigure(positionEnd).isEmpty()) {
            System.out.println("Na miejscu docelowym znajduje się figura. Nie możesz wykonać ruchu.");
        } else if (moved.getGraph() == "Q"){
			this.moveQeen(positionBeg, positionEnd);
		} else if (moved.getGraph() == "p") {
            this.movePawn(positionBeg, positionEnd);
        }
	}

	private void moveQeen(String positionBeg, String positionEnd) {

	}

	private void movePawn(String positionBeg, String positionEnd) {
	    if (this.movePawnForward(positionBeg, positionEnd)) {
	        return;
	    } else if (this.beatingByPawn(positionBeg, positionEnd)) {
            return;
        }
    }

    private boolean beatingByPawn(String positionBeg, String positionEnd) {
        Figure toMove = this.getFigure(positionBeg);
        if (this.isBeatingValid(positionBeg, positionEnd, toMove)) {
            this.removeFigure(positionBeg);
            this.setFigure(positionEnd, toMove);
            return true;
        } else {
            return false;
        }
    }

    private boolean isBeatingValid(String positionBeg, String positionEnd, Figure toMove) {
        int columnBeg = this.getColumn(positionBeg);
        int rowBeg = this.getRow(positionBeg);
        int columnEnd = this.getColumn(positionEnd);
        int rowEnd = this.getRow(positionEnd);

        if ((columnBeg + 2 < 7) && (rowBeg + 2 < 7)) {
            if (moveRD(positionBeg, positionEnd, toMove, columnBeg, rowBeg, columnEnd, rowEnd)) return true;
        }
        if ((columnBeg + 2 < 7) && (rowBeg - 2 > 0)) {
            if (moveRU(positionBeg, positionEnd, toMove, columnBeg, rowBeg, columnEnd, rowEnd)) return true;
        }
        if ((columnBeg - 2 > 0) && (rowBeg - 2 > 0)) {
            if (moveLU(positionBeg, positionEnd, toMove, columnBeg, rowBeg, columnEnd, rowEnd)) return true;
        }
        if ((columnBeg - 2 > 0) && (rowBeg + 2 < 7)) {
            if (moveLD(positionBeg, positionEnd, toMove, columnBeg, rowBeg, columnEnd, rowEnd)) return true;
        }
        return false;
    }

    private boolean moveLD(String positionBeg, String positionEnd, Figure toMove, int columnBeg, int rowBeg, int columnEnd, int rowEnd) {
        if (toMove.areDifferentColour(this.getFigure(columnBeg - 1, rowBeg + 1))) {
            if (columnEnd == columnBeg - 2 && rowEnd == rowBeg + 2) {
                this.removeFigure(this.getPosition(columnBeg-1, rowBeg +1));
                return true;
            } else {
                if (this.isBeatingValidRecusion(positionBeg, this.getPosition(columnBeg-2, rowBeg+2), positionEnd, toMove)) {
                    this.removeFigure(this.getPosition(columnBeg-1, rowBeg +1));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean moveLU(String positionBeg, String positionEnd, Figure toMove, int columnBeg, int rowBeg, int columnEnd, int rowEnd) {
        if (toMove.areDifferentColour(this.getFigure(columnBeg - 1, rowBeg - 1))) {
            if (columnEnd == columnBeg - 2 && rowEnd == rowBeg - 2) {
                this.removeFigure(this.getPosition(columnBeg-1, rowBeg -1));
                return true;
            } else {
                if (this.isBeatingValidRecusion(positionBeg, this.getPosition(columnBeg-2, rowBeg-2), positionEnd, toMove)) {
                    this.removeFigure(this.getPosition(columnBeg-1, rowBeg -1));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean moveRU(String positionBeg, String positionEnd, Figure toMove, int columnBeg, int rowBeg, int columnEnd, int rowEnd) {
        if (toMove.areDifferentColour(this.getFigure(columnBeg + 1, rowBeg - 1))) {
            if (columnEnd == columnBeg + 2 && rowEnd == rowBeg - 2) {
                this.removeFigure(this.getPosition(columnBeg+1, rowBeg -1));
                return true;
            } else {
                if (this.isBeatingValidRecusion(positionBeg, this.getPosition(columnBeg+2, rowBeg-2), positionEnd, toMove)) {
                    this.removeFigure(this.getPosition(columnBeg+1, rowBeg -1));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean moveRD(String positionBeg, String positionEnd, Figure toMove, int columnBeg, int rowBeg, int columnEnd, int rowEnd) {
        if (toMove.areDifferentColour(this.getFigure(columnBeg + 1, rowBeg + 1))) {
            if (columnEnd == columnBeg + 2 && rowEnd == rowBeg + 2) {
                this.removeFigure(this.getPosition(columnBeg+1, rowBeg +1));
                return true;
            } else {
                if (this.isBeatingValidRecusion(positionBeg, this.getPosition(columnBeg+2, rowBeg+2), positionEnd, toMove)) {
                    this.removeFigure(this.getPosition(columnBeg+1, rowBeg +1));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBeatingValidRecusion(String positionStart, String positionBeg, String positionEnd, Figure toMove) {
        int columnStart = this.getColumn(positionStart);
        int rowStart = this.getRow(positionStart);
        int columnBeg = this.getColumn(positionBeg);
        int rowBeg = this.getRow(positionBeg);
        int columnEnd = this.getColumn(positionEnd);
        int rowEnd = this.getRow(positionEnd);

        if ((columnBeg + 2 <= 7) && (rowBeg + 2 <= 7) && !((columnStart == columnBeg + 2) && (rowStart == rowBeg +2))) {
            if (moveRD(positionBeg, positionEnd, toMove, columnBeg, rowBeg, columnEnd, rowEnd)) return true;
        }
        if ((columnBeg + 2 <= 7) && (rowBeg - 2 >= 0) && !((columnStart == columnBeg + 2) && (rowStart == rowBeg -2))) {
            if (moveRU(positionBeg, positionEnd, toMove, columnBeg, rowBeg, columnEnd, rowEnd)) return true;
        }
        if ((columnBeg - 2 >= 0) && (rowBeg - 2 >= 0) && !((columnStart == columnBeg - 2) && (rowStart == rowBeg -2))) {
            if (moveLU(positionBeg, positionEnd, toMove, columnBeg, rowBeg, columnEnd, rowEnd)) return true;
        }
        if ((columnBeg - 2 >= 0) && (rowBeg + 2 <= 7) && !((columnStart == columnBeg - 2) && (rowStart == rowBeg +2))) {
            if (moveLD(positionBeg, positionEnd, toMove, columnBeg, rowBeg, columnEnd, rowEnd)) return true;
        }
        return false;
    }
/*        if ((columnBeg + 1 < 7) && (rowBeg + 1 < 7) && toMove.areDifferentColour(this.getFigure(columnBeg + 1, rowBeg + 1))) {
            if ((columnBeg + 2 < 7) && (rowBeg + 2 < 7) && this.getFigure(columnBeg + 2, rowBeg + 2).isEmpty()) {
                if (columnEnd == columnBeg + 2 && rowEnd == rowBeg + 2) {
                    return true;
                } else {
                    String position = this.getPosition(columnBeg + 2, rowBeg + 2);
                    this.isBeatingValid(position, positionEnd, toMove);
                }
            }
        } else if ((columnBeg + 1 < 7) && (rowBeg - 1 > 0) && toMove.areDifferentColour(this.getFigure(columnBeg + 1, rowBeg - 1))) {
            if ((columnBeg + 2 < 7) && (rowBeg - 2 > 0) && this.getFigure(columnBeg + 2, rowBeg - 2).isEmpty()) {
                if (columnEnd == columnBeg + 2 && rowEnd == rowBeg - 2) {
                    return true;
                } else {
                    String position = this.getPosition(columnBeg + 2, rowBeg - 2);
                    this.isBeatingValid(position, positionEnd, toMove);
                }
            }
        } else if ((columnBeg - 1 > 0) && (rowBeg - 1 > 0) && toMove.areDifferentColour(this.getFigure(columnBeg - 1, rowBeg - 1))) {
            if ((columnBeg - 2 > 0) && (rowBeg - 2 > 0) && this.getFigure(columnBeg - 2, rowBeg - 2).isEmpty()) {
                if (columnEnd == columnBeg - 2 && rowEnd == rowBeg - 2) {
                    return true;
                } else {
                    String position = this.getPosition(columnBeg - 2, rowBeg - 2);
                    this.isBeatingValid(position, positionEnd, toMove);
                }
            }
        } else if ((columnBeg - 1 > 0) && (rowBeg + 1 < 7) && toMove.areDifferentColour(this.getFigure(columnBeg - 1, rowBeg + 1))) {
            if ((columnBeg - 2 > 0) && (rowBeg + 2 < 7) && this.getFigure(columnBeg - 2, rowBeg + 2).isEmpty()) {
                if (columnEnd == columnBeg - 2 && rowEnd == rowBeg + 2) {
                    return true;
                } else {
                    String position = this.getPosition(columnBeg - 2, rowBeg + 2);
                    this.isBeatingValid(position, positionEnd, toMove);
                }
            }
        }
	return true;
	}

	private boolean movePawnForward(String positionBeg, String positionEnd) {
        int columnBeg = this.getColumn(positionBeg);
        int rowBeg = this.getRow(positionBeg);
        int columnEnd = this.getColumn(positionEnd);
        int rowEnd = this.getRow(positionEnd);
        Figure toMove = this.getFigure(positionBeg);

        if (toMove.getColour() == FigureColour.WHITE) {
            if ( ((columnBeg == columnEnd + 1) || (columnBeg == columnEnd - 1)) && (rowBeg == rowEnd - 1)) {
                return moveForward(positionBeg, positionEnd);
            }
        } else if (toMove.getColour() == FigureColour.BLACK) {
            if (((columnBeg == columnEnd + 1) || (columnBeg == columnEnd - 1)) && (rowBeg == rowEnd + 1)) {
                return moveForward(positionBeg, positionEnd);
            }
        }
        return false;
    }

    private boolean moveForward(String positionBeg, String positionEnd) {
        Figure toMove = this.getFigure(positionBeg);
	    this.removeFigure(positionBeg);
        this.setFigure(positionEnd, toMove);
        return true;
    }


    public void initialLayout() {
        for (int row = 0; row < board.size(); row++) {
            if (row == 0 || row == 2) {
                for (int col = 0; col < this.board.get(row).getBoardRow().size(); col = col + 2) {
                    this.board.get(row).setFigure(col, new Pawn(FigureColour.WHITE, this.getPosition(col, row)));
                }
            } else if (row == 1) {
                for (int col = 1; col < this.board.get(row).getBoardRow().size(); col = col + 2) {
                    this.board.get(row).setFigure(col, new Pawn(FigureColour.WHITE, this.getPosition(col, row)));
                }
            } else if (row == 5 || row ==7) {
                for (int col = 1; col < this.board.get(row).getBoardRow().size(); col = col + 2) {
                    this.board.get(row).setFigure(col, new Pawn(FigureColour.BLACK, this.getPosition(col, row)));
                }
            } else if (row == 6) {
                for (int col = 0; col < this.board.get(row).getBoardRow().size(); col = col + 2) {
                    this.board.get(row).setFigure(col, new Pawn(FigureColour.BLACK, this.getPosition(col, row)));
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



    private String getPosition(int column, int row) {
        String position;
        switch (column) {
            case 0 : position = "A"; break;
            case 1 : position = "B"; break;
            case 2 : position = "C"; break;
            case 3 : position = "D"; break;
            case 4 : position = "E"; break;
            case 5 : position = "F"; break;
            case 6 : position = "G"; break;
            case 7 : position = "H"; break;
            default : position = "100"; break;
        }

        switch (row) {
            case 0 : position += "1"; break;
            case 1 : position += "2"; break;
            case 2 : position += "3"; break;
            case 3 : position += "4"; break;
            case 4 : position += "5"; break;
            case 5 : position += "6"; break;
            case 6 : position += "7"; break;
            case 7 : position += "8"; break;
            default : position += "100"; break;
        }
        return position;
    }
*/

