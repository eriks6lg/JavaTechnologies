package main.java.ee.itcollege.tetris.parts;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Figure extends Group {

	public void move(int deltaX, int deltaY) {
		setLayoutX(getLayoutX() + deltaX * Block.SIZE);
		setLayoutY(getLayoutY() + deltaY * Block.SIZE);
		ObservableList<Node> children = getChildren();
		for(Node node: children) {
			Block block = (Block)node;
			block.setCoordinateX(block.getCoordinateX()+deltaX*Block.SIZE);
			block.setCoordinateY(block.getCoordinateY()+deltaY*Block.SIZE);
		}

	}

	public int hasLine() {
		if(getChildren().size() >=10) {
			int[] values = new int[20];
			for(Node node: getChildren()) {
				Block block = (Block)node;
				values[block.getCoordinateY()/40] +=1;
			}
			for(int i=0; i<values.length; i++) {
				if(values[i]==10)
					return i;
			}
		}
		return -1;
	}

	public int removeLines() {
		if(hasLine()>=0) {
			int numberOfLines = 0;
			while(hasLine()>=0) {
				int line = hasLine();
				ArrayList<Block> list = new ArrayList<Block>();
				for(Node node: getChildren()) {
					Block block = (Block)node;
					if(block.getCoordinateY()/40 == line)
						list.add(block);
					else if(block.getCoordinateY()/40 < line)
						block.setCoordinateY(block.getCoordinateY() + Block.SIZE);
				}
				getChildren().removeAll(list);
				numberOfLines++;
			}
			return numberOfLines;
		}
		return 0;
	}

	public void meltFigure(Figure figure)  {

		ArrayList<Block> list = new ArrayList<Block>();

		for(Node node: figure.getChildren()) {
			Block block = (Block)node;
			list.add(block);

		}
		getChildren().addAll(list);

	}

	public void refreshFigure() {
		setLayoutX(0);
		setLayoutY(0);
		for(Node node: getChildren()) {
			Block block = (Block)node;
			block.setX(block.getCoordinateX());
			block.setY(block.getCoordinateY());
		}
	}

	public void rotateClockwise() {

		ObservableList<Node> children = getChildren();

		for(Node node: children) {
			if(node instanceof Block) {
				Block block = (Block) node;
				int x = (int)block.getX();
				int y = (int)block.getY();
				block.setX(-block.getY());
				block.setY(x);

				block.setCoordinateX(block.getCoordinateX() - x + (int)block.getX());
				block.setCoordinateY(block.getCoordinateY() - y + (int)block.getY());
			}
		}


	}

	public boolean hasCollision(Figure figure) {

			for(Node ourNode: getChildren()) {
				Block ourBlock = (Block)ourNode;
				for(Node theirNode: figure.getChildren()) {
					Block theirBlock = (Block)theirNode;
					if(ourBlock.getCoordinateX() == theirBlock.getCoordinateX() &&
							(ourBlock.getCoordinateY() == theirBlock.getCoordinateY()-Block.SIZE ||
							ourBlock.getCoordinateY() == theirBlock.getCoordinateY()))
						return true;

				}

			}

		return false;
	}

	/**
	 * @return -1 if on left side, 0 if not on side, 1 if on right side.
	 */
	public int reachedSide() {

		for(Node node: getChildren()) {
			Block block = (Block)node;
			if(block.getCoordinateX() <= 0)
				return -1;
			else if(block.getCoordinateX() >= 9*Block.SIZE)
				return 1;
		}
		return 0;
	}

	public void setColor(Color color) {
		for(Node node: getChildren()) {
			Block block = (Block)node;
			block.setFill(color);
		}
	}

	/**
	 * @param figure
	 * @return -1 if has left, 1 if has right, 2 if has both, 0 if has none.
	 */
	public int reachedBlock(Figure figure) {
		boolean hasLeft = false;
		boolean hasRight = false;

		for(Node ourNode: getChildren()) {
			Block ourBlock = (Block)ourNode;
			for(Node theirNode: figure.getChildren()) {
				Block theirBlock = (Block)theirNode;
				if(ourBlock.getCoordinateY() == theirBlock.getCoordinateY() &&
						ourBlock.getCoordinateX() == theirBlock.getCoordinateX()-Block.SIZE) {
					hasRight = true;
				}
				if(ourBlock.getCoordinateY() == theirBlock.getCoordinateY() &&
						ourBlock.getCoordinateX() == theirBlock.getCoordinateX()+Block.SIZE) {
					hasLeft = true;
				}

			}

		}
		if(hasLeft && hasRight)
			return 2;
		else if(hasLeft && !hasRight)
			return -1;
		else if(!hasLeft && hasRight)
			return 1;
		else
			return 0;
	}

	public boolean reachedBottom() {
		for(Node node: getChildren()) {
			Block block = (Block)node;
			if(block.getCoordinateY() >= 19*Block.SIZE)
				return true;

		}
		return false;
	}
	
}
