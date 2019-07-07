package interfaces;

import boardElements.Position;

public interface CommunicationWithPlayerInterface {
	boolean setGameMode();
	boolean setColoure();
	Position selectFigure();
	Position selectEndPosition();

}
