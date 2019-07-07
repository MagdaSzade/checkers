package boardElements;

public class PositionError extends Throwable {
    static final String ILLEGAL_ROW = "Z�y format pola docelowego - rz�d.";
    static final String ILLEGAL_COL = "Z�y format pola docelowego - kolumna.";

    public PositionError(String msg) {
        super(msg);
    }
}