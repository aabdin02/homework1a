package homework1a2;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class JUNIT {
	private Grid grid;
	private Piece barShape;
	int expected;

	@Test
	public void test() {
		grid = new Grid();
		barShape = new BarShape(2,4,grid);
		
		barShape.rotate();
		
		
	}

}
