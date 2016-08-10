package homework1a2;



import java.awt.Color;

public class BarShape extends AbstractPiece{
	
	public BarShape(int r, int c, Grid g) {
		super(g);
		//grid = g;
		square = new Square[PIECE_COUNT];
		ableToMove = true;

		// Create the squares
		square[0] = new Square(g, r, c-1, Color.CYAN, true);
		square[1] = new Square(g, r, c, Color.CYAN, true);
		square[2] = new Square(g, r, c + 1, Color.cyan, true);
		square[3] = new Square(g, r, c + 2, Color.cyan, true);
	}
	
	public int row(){
		return row;
	}

}

