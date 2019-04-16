package figures;

import org.junit.Assert;
import org.junit.Test;

public class FigureTestSuite {

    @Test
    public void testGetColour() {
        //Given
        Figure figure = new Figure(FigureColour.WHITE, "Q");
        //When
        FigureColour figureColour = figure.getColour();
        //Then
        Assert.assertEquals(FigureColour.WHITE, figureColour);
    }

    @Test
    public void testGetGraph() {
        //Given
        Figure figure = new Figure(FigureColour.WHITE, "Q");
        //When
        String figureGraph = figure.getGraph();
        //Then
        Assert.assertEquals("Q", figureGraph);
    }

    @Test
    public void testAreDifferentColourFalse() {
        //Given
        Figure figure1 = new Figure(FigureColour.WHITE, "Q");
        Figure figure2 = new Figure(FigureColour.WHITE, "p");
        Figure figure3 = new Figure(FigureColour.BLACK, "Q");
        Figure figure4 = new Figure(FigureColour.BLACK, "p");
        //When
        //Then
        Assert.assertFalse(figure1.areDifferentColour(figure2));
        Assert.assertFalse(figure3.areDifferentColour(figure4));
    }

    @Test
    public void testAreDifferentColourTrue() {
        //Given
        Figure figure1 = new Figure(FigureColour.WHITE, "Q");
        Figure figure2 = new Figure(FigureColour.BLACK, "p");
        //When
        //Then
        Assert.assertTrue(figure1.areDifferentColour(figure2));
        Assert.assertTrue(figure2.areDifferentColour(figure1));
    }

    @Test
    public void testToString() {
        //Given
        Figure figure1 = new Figure(FigureColour.WHITE, "Q");
        //When
        String toString = figure1.toString();
        //Then
        Assert.assertEquals("WQ", toString);
    }

    @Test
    public void testIsEmpty() {
        //Given
        Figure figure1 = new Figure(FigureColour.NONE, " ");
        //When
        //Then
        Assert.assertTrue(figure1.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        //Given
        Figure figure1 = new Figure(FigureColour.BLACK, "Q");
        //When
        //Then
        Assert.assertFalse(figure1.isEmpty());
    }

    @Test
    public void testFigures() {
        //Given
        Figure figure1 = new Queen(FigureColour.BLACK);
        Figure figure2 = new Pawn(FigureColour.BLACK);
        Figure figure3 = new None();
        //When
        String toStringQueen = figure1.toString();
        String toStringPawn = figure2.toString();
        String toStringNone = figure3.toString();
        //Then
        Assert.assertEquals("BQ", toStringQueen);
        Assert.assertEquals("Bp", toStringPawn);
        Assert.assertEquals("  ", toStringNone);
    }
}
