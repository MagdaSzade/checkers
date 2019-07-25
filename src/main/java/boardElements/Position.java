package boardElements;

public class Position {
	private int col;
	private int row;

	public Position(String position) throws PositionError {
		this.col = getColumn(position);
		this.row = getRow(position);
	}

	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}

	public int getColumn() {
		return this.col;
	}

	public int getRow() {
		return this.row;
	}

	public String getPosition() throws PositionError {
		String position = getColumnString(col) + getRowString(row);
		return position;
	}

	private int getColumn(String position) throws PositionError {
		int col;
		switch (position.charAt(0)) {
		case 'A':
			col = 0;
			break;
		case 'B':
			col = 1;
			break;
		case 'C':
			col = 2;
			break;
		case 'D':
			col = 3;
			break;
		case 'E':
			col = 4;
			break;
		case 'F':
			col = 5;
			break;
		case 'G':
			col = 6;
			break;
		case 'H':
			col = 7;
			break;
		default:
			throw new PositionError(PositionError.ILLEGAL_COL);
		}
		return col;
	}

	private int getRow(String position) throws PositionError {
		int row;
		switch (position.charAt(1)) {
		case '1':
			row = 7;
			break;
		case '2':
			row = 6;
			break;
		case '3':
			row = 5;
			break;
		case '4':
			row = 4;
			break;
		case '5':
			row = 3;
			break;
		case '6':
			row = 2;
			break;
		case '7':
			row = 1;
			break;
		case '8':
			row = 0;
			break;
		default:
			throw new PositionError(PositionError.ILLEGAL_ROW);
		}
		return row;
	}

	private static String getColumnString(int col) throws PositionError {
		char colChar;
		switch (col) {
		case 0:
			colChar = 'A';
			break;
		case 1:
			colChar = 'B';
			break;
		case 2:
			colChar = 'C';
			break;
		case 3:
			colChar = 'D';
			break;
		case 4:
			colChar = 'E';
			break;
		case 5:
			colChar = 'F';
			break;
		case 6:
			colChar = 'G';
			break;
		case 7:
			colChar = 'H';
			break;
		default:
			throw new PositionError(PositionError.ILLEGAL_COL);
		}
		return String.valueOf(colChar);
	}

	private static String getRowString(int row) throws PositionError {
		char rowChar;
		switch (row) {
		case 7:
			rowChar = '1';
			break;
		case 6:
			rowChar = '2';
			break;
		case 5:
			rowChar = '3';
			break;
		case 4:
			rowChar = '4';
			break;
		case 3:
			rowChar = '5';
			break;
		case 2:
			rowChar = '6';
			break;
		case 1:
			rowChar = '7';
			break;
		case 0:
			rowChar = '8';
			break;
		default:
			throw new PositionError(PositionError.ILLEGAL_ROW);
		}
		return String.valueOf(rowChar);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Position) {
			Position positionToCompare = (Position) o;
			if (this.col == positionToCompare.getColumn() && this.row == positionToCompare.getRow()) {
				return true;
			}
		}
		return false;
	}
}

