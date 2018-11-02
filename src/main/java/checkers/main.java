package checkers;

public class main {

    public static void main(String[] args) {
      Board board = new Board();

      System.out.println(board.toString());

      board.setFigure("D5", new Pawn(FigureColour.WHITE));

      System.out.println(board.toString());

      board.move("D5", "E6");

      System.out.println(board.toString());

    }
}
