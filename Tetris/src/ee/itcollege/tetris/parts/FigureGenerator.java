package ee.itcollege.tetris.parts;

import ee.itcollege.tetris.parts.Block;
import ee.itcollege.tetris.parts.Figure;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;

import java.awt.*;

public class FigureGenerator {
	
	public static Figure createFigure() {

		Figure figure = new Figure();

		int chooser = (int)(Math.random()*7);

		switch(chooser) {
			case 0:
				figure.getChildren().add(new Block(0, -1, Color.BLUE));
				figure.getChildren().add(new Block(0, 0, Color.BLUE));
				figure.getChildren().add(new Block(0, 1, Color.BLUE));
				figure.getChildren().add(new Block(1, 1, Color.BLUE));

				break;
			case 1:
				figure.getChildren().add(new Block(0, -2, Color.GREEN));
				figure.getChildren().add(new Block(0, -1, Color.GREEN));
				figure.getChildren().add(new Block(0, 0, Color.GREEN));
				figure.getChildren().add(new Block(0, 1, Color.GREEN));
				break;
			case 2:
				figure.getChildren().add(new Block(-1, 0, Color.YELLOW));
				figure.getChildren().add(new Block(0, 0, Color.YELLOW));
				figure.getChildren().add(new Block(1, 0, Color.YELLOW));
				figure.getChildren().add(new Block(0, -1, Color.YELLOW));
				break;
			case 3:
				figure.getChildren().add(new Block(0, -1, Color.RED));
				figure.getChildren().add(new Block(0, 0, Color.RED));
				figure.getChildren().add(new Block(0, 1, Color.RED));
				figure.getChildren().add(new Block(-1, 1, Color.RED));
				break;
			case 4:
				figure.getChildren().add(new Block(0, 0, Color.BROWN));
				figure.getChildren().add(new Block(0, 1, Color.BROWN));
				figure.getChildren().add(new Block(1, 0, Color.BROWN));
				figure.getChildren().add(new Block(1, 1, Color.BROWN));
				break;
			case 5:
				figure.getChildren().add(new Block(0, -1, Color.PINK));
				figure.getChildren().add(new Block(0, 0, Color.PINK));
				figure.getChildren().add(new Block(1, 0, Color.PINK));
				figure.getChildren().add(new Block(1, 1, Color.PINK));
				break;
			case 6:
				figure.getChildren().add(new Block(1, -1, Color.VIOLET));
				figure.getChildren().add(new Block(1, 0, Color.VIOLET));
				figure.getChildren().add(new Block(0, 0, Color.VIOLET));
				figure.getChildren().add(new Block(0, 1, Color.VIOLET));
		}

		return figure;
	}

}
