package figures;

public class Figure {
	protected FigureColour colour;
	protected String graph;

	public Figure(FigureColour colour, String graph) {
		this.colour = colour;
		this.graph = graph;
	}

	@Override
	public String toString() {
		String toString = "";
		switch (this.colour) {
			case WHITE: toString += "W";
				break;
			case BLACK: toString += "B";
				break;
			case NONE: toString += " ";
				break;
			default: toString += " "; break;
		}
		toString += this.graph;

		return toString;
	}

	public FigureColour getColour() {
		return this.colour;
	}

	public String getGraph() {
		return this.graph;
	}

	public boolean areDifferentColour(Figure checkFigure) {
	    if (this.getColour().equals(checkFigure.getColour())) {
	        return false;
        } else {
            return true;
        }
    }

    public boolean isEmpty() {
	    if (this.getGraph() == " ") {
	        return true;
        } else {
	        return false;
        }
    }
}
