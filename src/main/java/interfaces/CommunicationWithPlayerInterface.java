package interfaces;

import boardElements.Position;
import boardElements.Board;
import boardElements.Player;

public interface CommunicationWithPlayerInterface {
	void welcomeMassage();
	String setName(String player);
	boolean setOponentType();
	boolean setColoure();
	Position selectFigure(Board board, Player player);
	Position selectEndPosition(Board board, Player player, Position startPosition);

}
