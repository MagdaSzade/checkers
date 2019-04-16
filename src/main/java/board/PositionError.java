package board;

public class PositionError extends Throwable {
    static final String ILLEGAL_ROW = "Podałeś zły format pola docelowego - rząd.";
    static final String ILLEGAL_COL = "Podałeś zły format pola docelowego - kolumna.";

    public PositionError(String msg) {
        super(msg);
    }
}
