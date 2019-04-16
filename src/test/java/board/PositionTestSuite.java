package board;

import org.junit.Assert;
import org.junit.Test;

public class PositionTestSuite {

    @Test
    public void testGetColumn() throws PositionError{
        //Given
        Position position = new Position("A1");
        //When
        int col = position.getColumn();
        int row = position.getRow();
        //Then
        Assert.assertEquals(0, col);
        Assert.assertEquals(7, row);
    }

    @Test(expected = PositionError.class)
    public void testThrowErrorColumn() throws PositionError{
        //Given
        Position position = new Position("Z1");
        //When
        int col = position.getColumn();
    }

    @Test(expected = PositionError.class)
    public void testThrowErrorRow() throws PositionError {
        //Given
        Position position = new Position("Am");
        //When
        int col = position.getRow();
    }

    @Test
    public void testGetPosition() throws PositionError {
        //Given
        //When
        String position = new Position(0,0).getPosition();
        //Then
        Assert.assertEquals("A8", position);
    }

    @Test(expected = PositionError.class)
    public void testGetPositionShouldThrowException() throws PositionError {
        //Given
        //When
        new Position(15,9).getPosition();
        //Then
    }

}
