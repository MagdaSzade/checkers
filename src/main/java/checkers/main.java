package checkers;

public class main {

    public static void main(String[] args) {
      Board board = new Board();

      System.out.println(board.toString());

      board.startDisplay();

      System.out.println(board.toString());
      System.out.println(board.getFigure(0,0));

      board.setFigure(2,5, new Queen(FigureColour.BLACK));

      System.out.println(board.toString());
    }
}
