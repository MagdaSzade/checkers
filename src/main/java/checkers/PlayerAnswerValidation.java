package checkers;

public class PlayerAnswerValidation {

    public boolean isValid1or2(String command) {
        if (command.charAt(0) == '1' || command.charAt(0) == '2' || command.charAt(0) == 'q' || command.charAt(0) == 'Q') {
            return true;
        }
        return false;
    }

    public boolean isChosenColourValid(String command) {
        if (command.charAt(0) == 'B' || command.charAt(0) == 'W' || command.charAt(0) == 'Q'
            || command.charAt(0) == 'b' || command.charAt(0) == 'w' || command.charAt(0) == 'q') {
            return true;
        }
        return false;
    }
}
