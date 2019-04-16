package board;

import figures.Figure;
import figures.FigureColour;
import figures.Queen;
import org.junit.Assert;
import org.junit.Test;

public class BoardTestSuite {

    @Test
    public void testBoard() {
        Board board = new Board();
        board.startBoard();
        System.out.println(board.toString());
    }

    @Test
    public void testSetFigure() throws PositionError {
        //Given
        Board board = new Board();
        board.setFigure(new Queen(FigureColour.BLACK), new Position("A2"));
        //When
        Figure figure = board.getFigure(new Position("A2"));
        //Then
        Assert.assertEquals(FigureColour.BLACK, figure.getColour());
        Assert.assertEquals("Q", figure.getGraph());
    }
}
