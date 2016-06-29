package main.java.ee.itcollege.tetris;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.ee.itcollege.tetris.parts.FigureGenerator;
import main.java.ee.itcollege.tetris.parts.Block;
import main.java.ee.itcollege.tetris.parts.Figure;

public class TetrisGame extends Application {

    public static void main(String[] args) {
        TetrisGame.launch(args);
    }

    Figure currentFigure = FigureGenerator.createFigure();
    Figure oldFigure = new Figure();
    Boolean hasEnded = false;


    @Override
    public void start(Stage stage) throws Exception {
        Pane layout = new Pane();

        Scene scene = new Scene(layout, Block.SIZE * 10, Block.SIZE * 20);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (KeyCode.RIGHT.equals(event.getCode()) && !(currentFigure.reachedSide() == 1)
                    && currentFigure.reachedBlock(oldFigure) <=0 && !hasEnded) {
                currentFigure.move(1, 0);
            } else if (KeyCode.LEFT.equals(event.getCode()) && !(currentFigure.reachedSide() == -1)
                     && currentFigure.reachedBlock(oldFigure) != -1 &&
                    currentFigure.reachedBlock(oldFigure) != 2 && !hasEnded) {
                currentFigure.move(-1, 0);
            } else if (KeyCode.DOWN.equals(event.getCode()) && !currentFigure.reachedBottom() && !currentFigure.hasCollision(oldFigure)
                    && !hasEnded) {
                currentFigure.move(0, 1);
            } else if (KeyCode.UP.equals(event.getCode()) && !currentFigure.reachedBottom() &&
                    currentFigure.reachedBlock(oldFigure) == 0 && !hasEnded) {
                currentFigure.rotateClockwise();
                currentFigure.rotateClockwise();
                currentFigure.rotateClockwise();
                Block block = (Block) currentFigure.getChildren().get(0);
                System.out.println(block.getCoordinateX() + " " + block.getCoordinateY());
            }
        });

        Text scoreBox = new Text("0");
        scoreBox.setLayoutY(30);
        scoreBox.setLayoutX(30);
        scoreBox.setFont(new Font("Arial", 40));
        scoreBox.setFill(Color.RED);

        currentFigure.move(4, 0);
        layout.getChildren().addAll(oldFigure, currentFigure, scoreBox);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int score = 0;
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {

                        if (!currentFigure.reachedBottom() && !(currentFigure.hasCollision(oldFigure))) {
                            currentFigure.move(0, 1);


                        } else if (!currentFigure.reachedBottom() && currentFigure.hasCollision(oldFigure) && currentFigure.getLayoutY()==0) {

                            oldFigure.setColor(Color.BLACK);
                            currentFigure.setColor(Color.BLACK);
                            timer.cancel();
                            timer.purge();
                            hasEnded = true;

                        } else {
                                oldFigure.meltFigure(currentFigure);

                                currentFigure = FigureGenerator.createFigure();
                                layout.getChildren().add(currentFigure);

                                currentFigure.move(4, 0);
                                oldFigure.refreshFigure();
                                if(oldFigure.hasLine()>=0) {
                                    int lines = oldFigure.removeLines();
                                    oldFigure.refreshFigure();
                                    score += lines;
                                    scoreBox.setText(String.valueOf(score));
                                }

                            }
                        }

                });

            }
        }, 1000, 1000);

        stage.setOnCloseRequest(e -> System.exit(0));
        stage.setScene(scene);
        stage.show();
    }

}
