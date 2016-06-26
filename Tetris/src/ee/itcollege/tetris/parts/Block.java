package ee.itcollege.tetris.parts;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle  {
	
	public static final int SIZE = 40;

	public int coordinateX;
	public int coordinateY;

	public Block(int x, int y) {
		super(x * SIZE, y * SIZE, SIZE, SIZE);
		coordinateX = x * Block.SIZE;
		coordinateY = y * Block.SIZE;

		setFill(Color.BLACK);
	}
	public Block(int x, int y, Color color) {
		super(x * SIZE, y * SIZE, SIZE, SIZE);
		coordinateX = x * Block.SIZE;
		coordinateY = y * Block.SIZE;

		setFill(color);
	}

}
