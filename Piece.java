/**
 * All of the method signatures currently in LShape 
 */
package homework1a2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface Piece {

	/**
	 * For drawing the piece.
	 * 
	 * @param g
	 */
	void draw(Graphics g);

	/**
	 * For moving the piece to different directions.
	 * 
	 * @param direction
	 */
	void move(Direction direction);

	/**
	 * For dropping the piece immediately.
	 * 
	 * @param
	 */
	void dropPiece();

	/**
	 * gets the location of the piece
	 * 
	 * @return
	 */
	Point[] getLocations();

	/**
	 * Gets the color of the piece.
	 * 
	 * @return
	 */

	Color getColor();

	/**
	 * Figures out whether the piece can move or not.
	 * 
	 * @param direction
	 */

	boolean canMove(Direction direction);

	/**
	 * Gets the square at the location.
	 * 
	 * @return
	 */

	Square[] getSquare();

	/**
	 * rotate the piece in the given direction.
	 * 
	 * @param direction
	 */

	void rotate();
	/**
	 * check whether the piece can rotate or not.
	 * @return
	 */
	boolean canRotate();

	

	int row();
	int col();
	

}
