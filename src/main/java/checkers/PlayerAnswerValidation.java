package checkers;

import boardElements.Board;
import boardElements.Position;
import figures.FigureColour;

public class PlayerAnswerValidation {

	public boolean isHumanValid(String answer) {
		if (answer.equals("1") || answer.equals("2")) {
			return true;
		}
		return false;
	}
	
	public boolean isColourValid(String answer) {
		if (answer.equals("1") || answer.equals("2")) {
			return true;
		}
		return false;
	}
	
	public boolean isStartingPositionValid(Board board, FigureColour colour) {
		//SUB!!!
		return true;
	}
	
	public boolean isEndPositionValid(Board board, FigureColour colour, Position startPosition) {
		//SUB!!!
		return true;
	}
}
