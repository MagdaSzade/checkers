package boardElements;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import figures.Figure;
import figures.FigureColour;
import figures.Pawn;

public class MovesValidatorTestSuite {
	
	@Test
	public void initialBoardMovesBlack() {
		Board board = new Board();
		board.setInitalBoard();
		FigureColour colour = FigureColour.BLACK;
		MovesValidator validator = new MovesValidator();
		ArrayList<Position[]> listOfMoves = validator.isAnyMoveAvailable(board, colour);
		Assert.assertEquals(7, listOfMoves.size());
		Assert.assertEquals(new Position(2,1), listOfMoves.get(0)[0]);
		Assert.assertEquals(new Position(3,2), listOfMoves.get(0)[1]);
		Assert.assertEquals(new Position(2,1), listOfMoves.get(1)[0]);
		Assert.assertEquals(new Position(3,0), listOfMoves.get(1)[1]);
		Assert.assertEquals(new Position(2,3), listOfMoves.get(2)[0]);
		Assert.assertEquals(new Position(3,4), listOfMoves.get(2)[1]);
		Assert.assertEquals(new Position(2,3), listOfMoves.get(3)[0]);
		Assert.assertEquals(new Position(3,2), listOfMoves.get(3)[1]);
		Assert.assertEquals(new Position(2,5), listOfMoves.get(4)[0]);
		Assert.assertEquals(new Position(3,6), listOfMoves.get(4)[1]);
		Assert.assertEquals(new Position(2,5), listOfMoves.get(5)[0]);
		Assert.assertEquals(new Position(3,4), listOfMoves.get(5)[1]);
		Assert.assertEquals(new Position(2,7), listOfMoves.get(6)[0]);
		Assert.assertEquals(new Position(3,6), listOfMoves.get(6)[1]);	
	}
	
	@Test
	public void initialBoardMovesWhite() {
		Board board = new Board();
		board.setInitalBoard();
		FigureColour colour = FigureColour.WHITE;
		MovesValidator validator = new MovesValidator();
		ArrayList<Position[]> listOfMoves = validator.isAnyMoveAvailable(board, colour);
		Assert.assertEquals(7, listOfMoves.size());
		Assert.assertEquals(new Position(5,0), listOfMoves.get(0)[0]);
		Assert.assertEquals(new Position(4,1), listOfMoves.get(0)[1]);
		Assert.assertEquals(new Position(5,2), listOfMoves.get(1)[0]);
		Assert.assertEquals(new Position(4,3), listOfMoves.get(1)[1]);
		Assert.assertEquals(new Position(5,2), listOfMoves.get(2)[0]);
		Assert.assertEquals(new Position(4,1), listOfMoves.get(2)[1]);
		Assert.assertEquals(new Position(5,4), listOfMoves.get(3)[0]);
		Assert.assertEquals(new Position(4,5), listOfMoves.get(3)[1]);
		Assert.assertEquals(new Position(5,4), listOfMoves.get(4)[0]);
		Assert.assertEquals(new Position(4,3), listOfMoves.get(4)[1]);
		Assert.assertEquals(new Position(5,6), listOfMoves.get(5)[0]);
		Assert.assertEquals(new Position(4,7), listOfMoves.get(5)[1]);
		Assert.assertEquals(new Position(5,6), listOfMoves.get(6)[0]);
		Assert.assertEquals(new Position(4,5), listOfMoves.get(6)[1]);	
	}
	
	@Test
	public void zeroPossibleMoves() {
		Board board = new Board();
		board.setFigure(new Pawn(FigureColour.BLACK), new Position(0,0));
		board.setFigure(new Pawn(FigureColour.BLACK), new Position(0,2));
		board.setFigure(new Pawn(FigureColour.WHITE), new Position(1,1));
		MovesValidator validator = new MovesValidator();
		ArrayList<Position[]> listOfMoves = validator.isAnyMoveAvailable(board, FigureColour.WHITE);
		Assert.assertEquals(0, listOfMoves.size());
	}
	
	@Test
	public void onePossibleMoveBlack() {
		Board board = new Board();
		board.setFigure(new Pawn(FigureColour.BLACK), new Position(0,0));
		board.setFigure(new Pawn(FigureColour.BLACK), new Position(0,2));
		board.setFigure(new Pawn(FigureColour.WHITE), new Position(1,1));
		MovesValidator validator = new MovesValidator();
		ArrayList<Position[]> listOfMoves = validator.isAnyMoveAvailable(board, FigureColour.BLACK);
		Assert.assertEquals(1, listOfMoves.size());
		Assert.assertEquals(new Position(0,2), listOfMoves.get(0)[0]);	
		Assert.assertEquals(new Position(1,3), listOfMoves.get(0)[1]);	
	}
}
