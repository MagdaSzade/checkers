package boardElements;

import figures.FigureColour;
import figures.None;
import figures.Figure;
import boardElements.Position;
import boardElements.Board;
import java.util.ArrayList;


public class MovesValidator {
	
	public ArrayList<Position> longestBeatingChain(Board board, FigureColour colour) {
		//SUB!!!
		return null;
	}
	
	public ArrayList<Position[]> isAnyMoveAvailable(Board board, FigureColour colour) {
		ArrayList<Position[]> listOfPosibleMoves = new ArrayList<>();
		int direction = -1;
		if (colour == FigureColour.BLACK) {
			direction = 1;
		}
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				Position position = new Position(i,j);
				Figure figure = board.getFigure(position);
				if (figure.getColour() == colour) {
					if (figure.getGraph().equals("p")) {
						Position endPosition = new Position(i+direction, j+1);
						Position[] moveParametrs1 = new Position[2];
						moveParametrs1[0] = position;
						moveParametrs1[1] = endPosition;
						try {
							Figure isNull = board.getFigure(endPosition);
							if (isNull.getClass().equals(None.class)) {
								listOfPosibleMoves.add(moveParametrs1);
							}
						} catch (IndexOutOfBoundsException e) {
							
						}
						endPosition = new Position(i+direction, j-1);
						Position[] moveParametrs2 = new Position[2];
						moveParametrs2[0] = position;
						moveParametrs2[1] = endPosition;
						try {
							Figure isNull = board.getFigure(endPosition);
							if (isNull.getClass().equals(None.class)) {
								listOfPosibleMoves.add(moveParametrs2);
							}
						} catch (IndexOutOfBoundsException e) {
							
							
							
						}
					}
				}
			}
		}
		return listOfPosibleMoves;
	}
	
	
}
