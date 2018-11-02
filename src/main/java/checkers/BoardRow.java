package checkers;

import java.util.LinkedList;

public class BoardRow {
	LinkedList<Figure> boardRow = new LinkedList<Figure>();
	
	public BoardRow() {
		for (int i = 0; i<8; i++) {
			this.boardRow.add(new None());
		}
	}

	public LinkedList<Figure> getBoardRow() {
	    return this.boardRow;
    }

    public void setFigure(int col, Figure figure) {
        this.boardRow.remove(col);
        this.boardRow.add(col, figure);
    }

	@Override
	public String toString() {
		String toString = "";
		toString += "|";
		for  (int i = 0; i < this.boardRow.size(); i++) {
			toString += boardRow.get(i).toString() + "|";
		}
		return toString;
	}
}
