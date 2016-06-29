package ee.itcollege.tetris.parts;

import main.java.ee.itcollege.tetris.parts.Block;
import main.java.ee.itcollege.tetris.parts.Figure;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class FigureTest {

    public static double PRECISION = .001;

    @Test
    public void testReachedBottom() throws Exception {
        Figure figure = new Figure();
        Block block = new Block(0, 0);

        figure.getChildren().add(block);

        assertEquals(false, figure.reachedBottom());

        figure.move(0, 1);
        assertEquals(false, figure.reachedBottom());

        figure.move(0, 8);
        assertEquals(false, figure.reachedBottom());

        figure.move(2, 2);
        assertEquals(false, figure.reachedBottom());

        figure.move(0, 7);
        assertEquals(false, figure.reachedBottom());

        figure.move(0, 1);
        assertEquals(true, figure.reachedBottom());

        figure.move(3, 0);
        assertEquals(true, figure.reachedBottom());

        figure.move(0, 1);
        assertEquals(true, figure.reachedBottom());

    }

    @Test
    public void testReachedSide() throws Exception {
        Figure figure = new Figure();
        Block block = new Block(0, 0);

        figure.getChildren().add(block);

        assertEquals(-1, figure.reachedSide());

        figure.move(-1, 0);
        assertEquals(-1, figure.reachedSide());

        figure.move(1, 0);
        assertEquals(-1, figure.reachedSide());

        figure.move(0, 2);
        assertEquals(-1, figure.reachedSide());

        figure.move(0, 8);
        assertEquals(-1, figure.reachedSide());

        figure.move(1, 0);
        assertEquals(0, figure.reachedSide());

        figure.move(4, 0);
        assertEquals(0, figure.reachedSide());

        figure.move(4, 0);
        assertEquals(1, figure.reachedSide());

        figure.move(0, 5);
        assertEquals(1, figure.reachedSide());

        figure.move(1, 0);
        assertEquals(1, figure.reachedSide());

        figure.move(-1, 0);
        assertEquals(1, figure.reachedSide());

        figure.move(0, -20);
        assertEquals(1, figure.reachedSide());

    }

    @Test
    public void testHasCollision() throws Exception {

        Figure figure1 = new Figure();
        Figure figure2 = new Figure();

        Block block1 = new Block(0, 0);
        Block block2 = new Block(0, 0);

        figure1.getChildren().add(block1);
        figure2.getChildren().add(block2);



        figure1.move(0, 10);
        figure2.move(0, 9);
        assertEquals(true, figure2.hasCollision(figure1));

        figure2.move(1, 0);
        assertEquals(false, figure2.hasCollision(figure1));

        figure2.move(-2, 0);
        assertEquals(false, figure2.hasCollision(figure1));

        figure2.move(2, 0);
        assertEquals(false, figure2.hasCollision(figure1));

        figure2.move(0, 1);
        assertEquals(false, figure2.hasCollision(figure1));

        figure2.move(-1, 0);
        assertEquals(true, figure2.hasCollision(figure1));

        figure2.move(-1, 0);
        assertEquals(false, figure2.hasCollision(figure1));

        figure2.move(0, 1);
        assertEquals(false, figure2.hasCollision(figure1));

        figure2.move(1, 0);
        assertEquals(false, figure2.hasCollision(figure1));

        figure2.move(1, 0);
        assertEquals(false, figure2.hasCollision(figure1));



    }
    @Test
    public void testRotateClockwise() throws Exception {

        Figure figure = new Figure();
        Block block = new Block(1, 2);
        figure.getChildren().add(block);

        assertEquals(Block.SIZE, block.getX(), PRECISION);
        assertEquals(Block.SIZE * 2, block.getY(), PRECISION);

        assertEquals(Block.SIZE, block.getCoordinateX());
        assertEquals(Block.SIZE * 2, block.getCoordinateY());

        double x = block.getX();
        double y = block.getY();
        int coordinateX = block.getCoordinateX();
        int coordinateY = block.getCoordinateY();

        figure.rotateClockwise();
        assertEquals(Block.SIZE * -2, block.getX(), PRECISION);
        assertEquals(Block.SIZE, block.getY(), PRECISION);
        assertEquals(coordinateX - x + block.getX(), block.getCoordinateX(), PRECISION);
        assertEquals(coordinateY - y + block.getY(), block.getCoordinateY(), PRECISION);

        x = block.getCoordinateX();
        y = block.getCoordinateY();
        coordinateX = block.getCoordinateX();
        coordinateY = block.getCoordinateY();

        figure.rotateClockwise();
        assertEquals(Block.SIZE * -1, block.getX(), PRECISION);
        assertEquals(Block.SIZE * -2, block.getY(), PRECISION);
        assertEquals(coordinateX - x + block.getX(), block.getCoordinateX(), PRECISION);
        assertEquals(coordinateY - y + block.getY(), block.getCoordinateY(), PRECISION);

        x = block.getCoordinateX();
        y = block.getCoordinateY();
        coordinateX = block.getCoordinateX();
        coordinateY = block.getCoordinateY();

        figure.rotateClockwise();
        assertEquals(Block.SIZE * 2, block.getX(), PRECISION);
        assertEquals(Block.SIZE * -1, block.getY(), PRECISION);
        assertEquals(coordinateX - x + block.getX(), block.getCoordinateX(), PRECISION);
        assertEquals(coordinateY - y + block.getY(), block.getCoordinateY(), PRECISION);

        x = block.getCoordinateX();
        y = block.getCoordinateY();
        coordinateX = block.getCoordinateX();
        coordinateY = block.getCoordinateY();

        figure.rotateClockwise();
        assertEquals(Block.SIZE, block.getX(), PRECISION);
        assertEquals(Block.SIZE * 2, block.getY(), PRECISION);
        assertEquals(coordinateX - x + block.getX(), block.getCoordinateX(), PRECISION);
        assertEquals(coordinateY - y + block.getY(), block.getCoordinateY(), PRECISION);


    }

    @Test
    public void testMove() throws Exception {

        Figure figure = new Figure();
        Block block1 = new Block(0, 0);
        Block block2 = new Block(0, 1);
        Block block3 = new Block(0, 2);
        Block block4 = new Block(1, 2);
        figure.getChildren().addAll(block1, block2, block3, block4);

        figure.setLayoutX(0);
        figure.setLayoutY(0);

        assertEquals(0 * Block.SIZE, block1.getCoordinateX());
        assertEquals(0 * Block.SIZE, block1.getCoordinateY());
        assertEquals(0 * Block.SIZE, block2.getCoordinateX());
        assertEquals(1 * Block.SIZE, block2.getCoordinateY());
        assertEquals(0 * Block.SIZE, block3.getCoordinateX());
        assertEquals(2 * Block.SIZE, block3.getCoordinateY());
        assertEquals(1 * Block.SIZE, block4.getCoordinateX());
        assertEquals(2 * Block.SIZE, block4.getCoordinateY());


        figure.move(1, 0);
        assertEquals(Block.SIZE, figure.getLayoutX(), PRECISION);
        assertEquals(0, figure.getLayoutY(), PRECISION);

        assertEquals(1 * Block.SIZE, block1.getCoordinateX());
        assertEquals(0 * Block.SIZE, block1.getCoordinateY());
        assertEquals(1 * Block.SIZE, block2.getCoordinateX());
        assertEquals(1 * Block.SIZE, block2.getCoordinateY());
        assertEquals(1 * Block.SIZE, block3.getCoordinateX());
        assertEquals(2 * Block.SIZE, block3.getCoordinateY());
        assertEquals(2 * Block.SIZE, block4.getCoordinateX());
        assertEquals(2 * Block.SIZE, block4.getCoordinateY());

        figure.move(1, 0);
        assertEquals(Block.SIZE * 2, figure.getLayoutX(), PRECISION);
        assertEquals(0, figure.getLayoutY(), PRECISION);

        assertEquals(2 * Block.SIZE, block1.getCoordinateX());
        assertEquals(0 * Block.SIZE, block1.getCoordinateY());
        assertEquals(2 * Block.SIZE, block2.getCoordinateX());
        assertEquals(1 * Block.SIZE, block2.getCoordinateY());
        assertEquals(2 * Block.SIZE, block3.getCoordinateX());
        assertEquals(2 * Block.SIZE, block3.getCoordinateY());
        assertEquals(3 * Block.SIZE, block4.getCoordinateX());
        assertEquals(2 * Block.SIZE, block4.getCoordinateY());

        figure.move(0, 1);
        assertEquals(Block.SIZE * 2, figure.getLayoutX(), PRECISION);
        assertEquals(Block.SIZE, figure.getLayoutY(), PRECISION);

        assertEquals(2 * Block.SIZE, block1.getCoordinateX());
        assertEquals(1 * Block.SIZE, block1.getCoordinateY());
        assertEquals(2 * Block.SIZE, block2.getCoordinateX());
        assertEquals(2 * Block.SIZE, block2.getCoordinateY());
        assertEquals(2 * Block.SIZE, block3.getCoordinateX());
        assertEquals(3 * Block.SIZE, block3.getCoordinateY());
        assertEquals(3 * Block.SIZE, block4.getCoordinateX());
        assertEquals(3 * Block.SIZE, block4.getCoordinateY());

        figure.move(0, 2);
        assertEquals(Block.SIZE * 2, figure.getLayoutX(), PRECISION);
        assertEquals(Block.SIZE * 3, figure.getLayoutY(), PRECISION);

        assertEquals(2 * Block.SIZE, block1.getCoordinateX());
        assertEquals(3 * Block.SIZE, block1.getCoordinateY());
        assertEquals(2 * Block.SIZE, block2.getCoordinateX());
        assertEquals(4 * Block.SIZE, block2.getCoordinateY());
        assertEquals(2 * Block.SIZE, block3.getCoordinateX());
        assertEquals(5 * Block.SIZE, block3.getCoordinateY());
        assertEquals(3 * Block.SIZE, block4.getCoordinateX());
        assertEquals(5 * Block.SIZE, block4.getCoordinateY());

        figure.move(0, -1);
        assertEquals(Block.SIZE * 2, figure.getLayoutX(), PRECISION);
        assertEquals(Block.SIZE * 2, figure.getLayoutY(), PRECISION);

        assertEquals(2 * Block.SIZE, block1.getCoordinateX());
        assertEquals(2 * Block.SIZE, block1.getCoordinateY());
        assertEquals(2 * Block.SIZE, block2.getCoordinateX());
        assertEquals(3 * Block.SIZE, block2.getCoordinateY());
        assertEquals(2 * Block.SIZE, block3.getCoordinateX());
        assertEquals(4 * Block.SIZE, block3.getCoordinateY());
        assertEquals(3 * Block.SIZE, block4.getCoordinateX());
        assertEquals(4 * Block.SIZE, block4.getCoordinateY());

        figure.move(-1, 0);
        assertEquals(Block.SIZE, figure.getLayoutX(), PRECISION);
        assertEquals(Block.SIZE * 2, figure.getLayoutY(), PRECISION);

        assertEquals(1 * Block.SIZE, block1.getCoordinateX());
        assertEquals(2 * Block.SIZE, block1.getCoordinateY());
        assertEquals(1 * Block.SIZE, block2.getCoordinateX());
        assertEquals(3 * Block.SIZE, block2.getCoordinateY());
        assertEquals(1 * Block.SIZE, block3.getCoordinateX());
        assertEquals(4 * Block.SIZE, block3.getCoordinateY());
        assertEquals(2 * Block.SIZE, block4.getCoordinateX());
        assertEquals(4 * Block.SIZE, block4.getCoordinateY());

        figure.move(0, 0);
        assertEquals(Block.SIZE, figure.getLayoutX(), PRECISION);
        assertEquals(Block.SIZE * 2, figure.getLayoutY(), PRECISION);

        assertEquals(1 * Block.SIZE, block1.getCoordinateX());
        assertEquals(2 * Block.SIZE, block1.getCoordinateY());
        assertEquals(1 * Block.SIZE, block2.getCoordinateX());
        assertEquals(3 * Block.SIZE, block2.getCoordinateY());
        assertEquals(1 * Block.SIZE, block3.getCoordinateX());
        assertEquals(4 * Block.SIZE, block3.getCoordinateY());
        assertEquals(2 * Block.SIZE, block4.getCoordinateX());
        assertEquals(4 * Block.SIZE, block4.getCoordinateY());

        figure.move(1, 1);
        assertEquals(Block.SIZE * 2, figure.getLayoutX(), PRECISION);
        assertEquals(Block.SIZE * 3, figure.getLayoutY(), PRECISION);

        assertEquals(2 * Block.SIZE, block1.getCoordinateX());
        assertEquals(3 * Block.SIZE, block1.getCoordinateY());
        assertEquals(2 * Block.SIZE, block2.getCoordinateX());
        assertEquals(4 * Block.SIZE, block2.getCoordinateY());
        assertEquals(2 * Block.SIZE, block3.getCoordinateX());
        assertEquals(5 * Block.SIZE, block3.getCoordinateY());
        assertEquals(3 * Block.SIZE, block4.getCoordinateX());
        assertEquals(5 * Block.SIZE, block4.getCoordinateY());

        figure.move(-1, -4);
        assertEquals(Block.SIZE, figure.getLayoutX(), PRECISION);
        assertEquals(Block.SIZE * -1, figure.getLayoutY(), PRECISION);

        assertEquals(1 * Block.SIZE, block1.getCoordinateX());
        assertEquals(-1 * Block.SIZE, block1.getCoordinateY());
        assertEquals(1 * Block.SIZE, block2.getCoordinateX());
        assertEquals(0 * Block.SIZE, block2.getCoordinateY());
        assertEquals(1 * Block.SIZE, block3.getCoordinateX());
        assertEquals(1 * Block.SIZE, block3.getCoordinateY());
        assertEquals(2 * Block.SIZE, block4.getCoordinateX());
        assertEquals(1 * Block.SIZE, block4.getCoordinateY());

    }


    @Test
    public void testMeltFigure() throws Exception {
        Figure figure1 = new Figure();
        Figure figure2 = new Figure();

        Block block1 = new Block(0, 0);
        Block block2 = new Block(0, 1);
        Block block3 = new Block(7, 3);
        Block block4 = new Block(9, 2);

        figure1.getChildren().addAll(block1, block2);
        figure2.getChildren().addAll(block3, block4);

        int x1 = block3.getCoordinateX();
        int y1 = block3.getCoordinateY();
        int x2 = block4.getCoordinateX();
        int y2 = block4.getCoordinateY();


        assertEquals(true, figure1.getChildren().contains(block1));
        assertEquals(true, figure1.getChildren().contains(block2));
        assertEquals(false, figure1.getChildren().contains(block3));
        assertEquals(false, figure1.getChildren().contains(block4));

        figure1.meltFigure(figure2);

        assertEquals(true, figure1.getChildren().contains(block1));
        assertEquals(true, figure1.getChildren().contains(block2));
        assertEquals(true, figure1.getChildren().contains(block3));
        assertEquals(true, figure1.getChildren().contains(block4));
        assertEquals(false, figure2.getChildren().contains(block1));
        assertEquals(false, figure2.getChildren().contains(block2));
        assertEquals(false, figure2.getChildren().contains(block3));
        assertEquals(false, figure2.getChildren().contains(block4));

        assertEquals(x1, block3.getCoordinateX());
        assertEquals(y1, block3.getCoordinateY());
        assertEquals(x2, block4.getCoordinateX());
        assertEquals(y2, block4.getCoordinateY());


    }

    @Test
    public void testLines() throws Exception {

        Figure figure = new Figure();
        Block block1 = new Block(0, 0);
        Block block2 = new Block(1, 0);
        Block block3 = new Block(2, 0);
        Block block4 = new Block(3, 0);
        Block block5 = new Block(4, 0);
        Block block6 = new Block(5, 0);
        Block block7 = new Block(6, 0);
        Block block71 = new Block(6, 1);
        Block block8 = new Block(7, 0);
        Block block9 = new Block(8, 0);
        Block block10 = new Block(9, 0);
        Block block11 = new Block(0, 0);
        Block block22 = new Block(1, 0);
        Block block33 = new Block(2, 0);
        Block block44 = new Block(3, 0);
        Block block55 = new Block(4, 0);
        Block block66 = new Block(5, 0);
        Block block77 = new Block(6, 0);
        Block block88 = new Block(7, 0);
        Block block99 = new Block(8, 0);
        Block block1010 = new Block(9, 0);

        figure.getChildren().addAll(block1, block2, block3, block4, block5, block6, block7);
        assertEquals(-1, figure.hasLine());

        figure.getChildren().addAll(block71, block8, block9);
        assertEquals(-1, figure.hasLine());

        figure.getChildren().add(block10);
        figure.getChildren().remove(block3);
        assertEquals(-1, figure.hasLine());

        figure.getChildren().add(block3);
        assertEquals(0, figure.hasLine());

        assertEquals(1, figure.removeLines());

        assertEquals(-1, figure.hasLine());
        assertEquals(1, figure.getChildren().size());

        figure.getChildren().addAll(block11, block22, block33, block44, block55, block66, block77, block88, block99, block1010);
        assertEquals(0, figure.hasLine());
        assertEquals(11, figure.getChildren().size());

        figure.getChildren().addAll(new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(3, 1), new Block(4, 1),
                new Block(5, 1), new Block(7, 1), new Block(8, 1), new Block(9, 1));
        assertEquals(0, figure.hasLine());
        assertEquals(2, figure.removeLines());

        assertEquals(-1, figure.hasLine());

        figure.getChildren().addAll(new Block(0, 0), new Block(0, 1), new Block(0, 2), new Block(0, 3), new Block(0, 4),
                new Block(0, 5), new Block(0, 6), new Block(0, 7), new Block(0, 8), new Block(0, 9));
        assertEquals(-1, figure.hasLine());


    }

    @Test
    public void testReachedBlock() throws Exception {
        Figure figure1 = new Figure();
        Figure figure2 = new Figure();
        Figure figure3 = new Figure();

        figure1.getChildren().addAll(new Block(8, 8), new Block(8, 9));
        figure2.getChildren().addAll(new Block(7,7), new Block(7, 8));
        figure3.getChildren().add(new Block(0, 0));

        assertEquals(-1, figure1.reachedBlock(figure2));
        assertEquals(1, figure2.reachedBlock(figure1));
        assertEquals(0, figure1.reachedBlock(figure3));

        figure1.getChildren().add(new Block(6,7));

        assertEquals(2, figure2.reachedBlock(figure1));

    }
}