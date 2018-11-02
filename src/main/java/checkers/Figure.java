package checkers;

public class Figure {
	protected FigureColour colour;
	protected String graph;


	public String toString() {
		String toString = "";
		switch (this.colour) {
			case WHITE: toString += "w";
				break;
			case BLACK: toString += "b";
				break;
			case NONE: toString += " ";
				break;
			default: toString += " "; break;
		}
		toString += this.graph;

		return toString;
	}
}
