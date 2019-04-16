package checkers;

import org.junit.Assert;
import org.junit.Test;

public class PlayerAnswerValidationTestSuite {
    private PlayerAnswerValidation validator = new PlayerAnswerValidation();
    @Test
    public void testIsChosenColourValid() {
        //Given
        String correct1 = "W";
        String correct2 = "B";
        String correct3 = "Wid";
        String correct4 = "Bldj";
        String correct5 = "bldj";
        String correct6 = "wldj";
        //When & Then
        Assert.assertTrue(validator.isChosenColourValid(correct1));
        Assert.assertTrue(validator.isChosenColourValid(correct2));
        Assert.assertTrue(validator.isChosenColourValid(correct3));
        Assert.assertTrue(validator.isChosenColourValid(correct4));
        Assert.assertTrue(validator.isChosenColourValid(correct5));
        Assert.assertTrue(validator.isChosenColourValid(correct6));
    }

    @Test
    public void testIsChosenColourValidFalse() {
        //Given
        String incorrect = "hfew";
        //When & Then
        Assert.assertFalse(validator.isChosenColourValid(incorrect));
    }
}
