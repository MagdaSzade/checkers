package boardElements;

import figures.FigureColour;
import figures.None;
import figures.Figure;
import boardElements.Position;
import boardElements.Board;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MovesValidator {
	
	public ArrayList<Position> longestBeatingChain(Board board, FigureColour colour) {
		//SUB!!!
		return null;
	}
	
	public boolean isAnyMoveAvailable(Board board, FigureColour colour) {
		ArrayList<Position[]> listOfPosibleMoves = new ArrayList<>();
		int direction = 1;
		if (colour == FigureColour.BLACK) {
			direction = -1;
		}
		for (int i=0; i<8; i++) {
			for (int j=0; j<0; j++) {
				Position position = new Position(i,j);
				Figure figure = board.getFigure(position);
				if (figure.getColour() == colour) {
					if (figure.getGraph().equals("p")) {
						Position endPosition = new Position(i+direction, j+1);
						Position[] moveParametrs = new Position[2];
						moveParametrs[0] = position;
						moveParametrs[1] = endPosition;
						try {
							Figure isNull = board.getFigure(endPosition);
							if (isNull.getClass().equals(None.class)) {
								listOfPosibleMoves.add(moveParametrs);
							}
						} catch (IndexOutOfBoundsException e) {
							
						}
						endPosition = new Position(i+direction, j-1);
						try {
							Figure isNull = board.getFigure(endPosition);
							if (isNull.getClass().equals(None.class)) {
								listOfPosibleMoves.add
							}
						} catch (IndexOutOfBoundsException e) {
							
						}
					}
				}
			}
		}
		return false;
	}
	
	
}
