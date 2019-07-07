package boardElements;

public class PositionError extends Throwable {
    static final String ILLEGAL_ROW = "Z³y format pola docelowego - rz¹d.";
    static final String ILLEGAL_COL = "Z³y format pola docelowego - kolumna.";

    public PositionError(String msg) {
        super(msg);
    }
}