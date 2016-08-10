package homework1a2;

/**
 * All the instance variables in LShape should be in AbstractPiece.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

abstract class AbstractPiece implements Piece {
	boolean ableToMove;
	protected Square[] square;
	private Grid grid;
	int row, col;
	static final int PIECE_COUNT = 4;
	boolean canRotate;

	public AbstractPiece(Grid g) {
		grid = g;
	}

	public int row(){
		return row;
	}
	public int col(){
		return col;
	}
	/**
	 * Draws the piece on the given Graphics context
	 */
	public void draw(Graphics g) {
		for (int i = 0; i < PIECE_COUNT; i++) {
			square[i].draw(g);
		}
	}

	/**
	 * Moves the piece if possible Freeze the piece if it cannot move down
	 * anymore
	 * 
	 * @param direction
	 *            the direction to move
	 */
	public void move(Direction direction) {
		if (canMove(direction)) {
			for (int i = 0; i < PIECE_COUNT; i++)
				square[i].move(direction);
		}
		// if we couldn't move, see if because we're at the bottom
		else if (direction == Direction.DOWN) {
			ableToMove = false;
		}
	}

	public void dropPiece() {
		while (canMove(Direction.DOWN)) {
			for (int i = 0; i < PIECE_COUNT; i++) {
				square[i].move(Direction.DOWN);
			}
		}

	}
	
	

	/**
	 * Returns the (row,col) grid coordinates occupied by this Piece
	 * 
	 * @return an Array of (row,col) Points
	 */
	public Point[] getLocations() {
		Point[] points = new Point[PIECE_COUNT];
		for (int i = 0; i < PIECE_COUNT; i++) {
			points[i] = new Point(square[i].getRow(), square[i].getCol());
		}
		return points;
	}

	public String toString() {
		return "points[i]" + getLocations();
	}

	/**
	 * Return the color of this piece
	 */
	public Color getColor() {
		// all squares of this piece have the same color
		return square[0].getColor();
	}

	/**
	 * Returns if this piece can move in the given direction
	 * 
	 */
	public boolean canMove(Direction direction) {
		if (!ableToMove)
			return false;

		// Each square must be able to move in that direction
		boolean answer = true;
		for (int i = 0; i < PIECE_COUNT; i++) {

			answer = answer && square[i].canMove(direction);
		}

		return answer;
	}

	public Square[] getSquare() {

		return square;
	}

	@Override
	public void rotate() {
		// rotate in quarter turns if the down arrow key is pressed.
		if (canRotate()) {

			for (int i = 0; i < PIECE_COUNT; i++) {
			

				if (// canRotate() &&
				square[1].getRow() == square[i].getRow() - 1 // if it is 3
						&& square[1].getCol() == square[i].getCol() - 1
				// ||square[1].getCol()==square[i].getCol() + 1
				// && canRotate()
				) {
					square[i].setCol(square[1].getCol() - 1);
					square[i].setRow(square[1].getRow() + 1);
				}

				else if (// canRotate() &&
				square[1].getRow() == square[i].getRow() - 1 // if it is 2
						&& square[1].getCol() == square[i].getCol()) {
					square[i].setCol(square[1].getCol() - 1);
					square[i].setRow(square[1].getRow());

				}

				else if (// canRotate() &&
				square[1].getRow() == square[i].getRow() + 1 // if it is 0

						&& square[1].getCol() == square[i].getCol()) {
					square[i].setCol(square[1].getCol() + 1);
					square[i].setRow(square[1].getRow());
				}
				// starting of rotation #2
				else if (// canRotate() &&
				square[1].getCol() + 1 == square[i].getCol()
				&& square[1].getRow() == square[i].getRow()) {
					square[i].setCol(square[1].getCol());
					square[i].setRow(square[1].getRow() + 1);
				} 
				else if (square[1].getCol() + 2 == square[i].getCol() && 
						square[1].getRow() == square[i].getRow()) {
					square[i].setRow(square[1].getRow() - 2);
					square[i].setCol(square[1].getCol());
				} 
				else if (square[1].getCol() - 2 == square[i].getCol() 
						&& square[1].getRow() == square[i].getRow()) {
					
					square[i].setRow(square[1].getRow() + 2);
					square[i].setCol(square[1].getCol());
				}

				else if (square[1].getRow() - 2 == square[i].getRow() 
						&& square[1].getCol() == square[i].getCol()) {
					square[i].setCol(square[1].getCol() - 2);
					square[i].setRow(square[1].getRow());
				} else if (square[1].getRow() + 2 == square[i].getRow() 
						&& square[1].getCol() == square[i].getCol()) {
					square[i].setCol(square[1].getCol() + 2);
					square[i].setRow(square[1].getRow());
				}

				else if (// canRotate() &&
				square[1].getRow() == square[i].getRow()
						// if it is 0
						&& square[1].getCol() + 1 == square[i].getCol()) {
					square[i].setCol(square[1].getCol());
					square[i].setRow(square[1].getRow() + 1);
				}

				else if (// canRotate() &&
				square[1].getRow() == square[i].getRow() && // if it 2
						square[1].getCol() - 1 == square[i].getCol()) {
					square[i].setCol(square[1].getCol());
					square[i].setRow(square[1].getRow() - 1);
				} else if (// canRotate() &&
				square[1].getRow() + 1 == square[i].getRow() 
				&& square[1].getCol() - 1 == square[i].getCol()) {
					square[i].setCol(square[1].getCol() - 1);
					square[i].setRow(square[1].getRow() - 1);
				}
				// starting of rotation #3
				else if (// canRotate() &&
				square[1].getRow() + 1 == square[i].getRow()// if it is 0
						&& square[1].getCol() == square[i].getCol()) {
					square[i].setCol(square[1].getCol() - 1);
					square[i].setRow(square[1].getRow());
				}
				// No
				else if (// canRotate() &&
				square[1].getRow() - 1 == square[i].getRow()// if it is 2
						&& square[1].getCol() == square[i].getCol()) {
					square[i].setCol(square[1].getCol() + 1);
					square[i].setRow(square[1].getRow());
				} else if (// canRotate() &&
				square[1].getRow() - 1 == square[i].getRow()// if it is 3
						&& square[1].getCol() - 1 == square[i].getCol()) {
					square[i].setCol(square[1].getCol() + 1);
					square[i].setRow(square[1].getRow() - 1);
				}
				// starting of rotation #4
				else if (// canRotate() &&
				square[1].getRow() == square[i].getRow()// if it 0

						&& square[1].getCol() - 1 == square[i].getCol()) {
					square[i].setCol(square[1].getCol());
					square[i].setRow(square[1].getRow() - 1);
				} else if (// canRotate() &&
				square[1].getRow() == square[i].getRow() 
				&& square[1].getCol() + 1 == square[i].getCol()) {
					square[i].setCol(square[1].getCol());
					square[i].setRow(square[1].getRow() + 1);
				} else if (// canRotate() &&
				square[1].getRow() - 1 == square[i].getRow() 
				&& square[1].getCol() + 1 == square[i].getCol()) {
					square[i].setCol(square[1].getCol() + 1);
					square[i].setRow(square[1].getRow() + 1);
				}
			}
		}
	}
	/**
	 * A piece should only rotate if the grid squares that it would pass through 
	 * and occupy are all empty and in addition are all within the boundaries of the grid.
	 * (i.e. the row index is greater than or equal to zero and less than Grid.HEIGHT
	 * and the column index is greater than or equal to zero and less than Grid.WIDTH).
	 * To check if a square can move, 
	 */

	public boolean canRotate() {
		// Donot rotate if it reaches the end of the grid.
		int cX = square[1].getRow();
		int cY = square[1].getCol();
		int finalRow, finalCol, row, col;
		boolean canToRotate = true;

		for (int i = 0; i < PIECE_COUNT; i++) {

			row = square[i].getRow();
			col = square[i].getCol();
			finalRow = (cX + (square[i].getCol() - cY));
			finalCol = (cY - (square[i].getRow() - cX));

			// check if the rotation will pass through border
			if ((finalRow < 0) || (finalRow > Grid.HEIGHT - 1) 
					|| (finalCol < 0) || (finalCol > Grid.WIDTH - 1)) {
				canToRotate = false;
			}

			// if the square moved only horizontally
			
			if (row == finalRow) {
				for (int j= Math.min(col, finalCol); j <= Math.max(col, finalCol); j++) {
					if (grid.isSet(row, j)) {
						canToRotate = false;
					}
				}
			}

			// case where the square only move vertically
			if (col == finalCol) {
				for (int j = Math.min(row, finalRow); j <= Math.max(row, finalRow); j++) {
					if (grid.isSet(j, col)) {
						canToRotate = false;
					}
				}
			}

			// case where the square travel from South to West
			if ((row > finalRow) && (col > finalCol)) {
				for (int j = finalCol; j <= col; j++) {
					if (grid.isSet(row, j)) {
						canToRotate = false;
					}
				}
				for (int j = finalRow; j <= row; j++) {
					if (grid.isSet(j, finalCol)) {
						canToRotate = false;
					}
				}
			}

			// case where the square travel from West to North
			if ((row > finalRow) && (col < finalCol)) {
				for (int j = col; j <= finalCol; j++) {
					if (grid.isSet(finalRow, j)) {
						canToRotate = false;
					}
				}
				for (int j = finalRow; j <= row; j++) {
					if (grid.isSet(j, col)) {
						canToRotate = false;
					}
				}
			}

			// case where the square travel from North to East
			if ((row < finalRow) && (col < finalCol)) {
				for (int j = col; j <= finalCol; j++) {
					if (grid.isSet(row, j)) {
						canToRotate = false;
					}
				}
				for (int j = row; j <= finalRow; j++) {
					if (grid.isSet(j, finalCol)) {
						canToRotate = false;
					}
				}
			}

			// case where the square travel from East to South
			if ((row < finalRow) && (col > finalCol)) {
				for (int j = finalCol; j <= col; j++) {
					if (grid.isSet(finalRow, j)) {
						canToRotate = false;
					}
				}
				for (int j = row; j <= finalRow; j++) {
					if (grid.isSet(j, col)) {
						canToRotate = false;
					}
				}
			}

		}
		return canToRotate;
	}

	

}
