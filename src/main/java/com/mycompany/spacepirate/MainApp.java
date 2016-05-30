package com.mycompany.spacepirate;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javafx.application.Application.launch;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainApp extends Application {
    public static int WINDOWWIDTH = 640;
    public static int WINDOWHEIGH = 860;

    Space universe;
    LoadAllImages loadAllImages = new LoadAllImages();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Pirate");

        StackPane root = new StackPane();
        Canvas spaceCanvas = new Canvas(WINDOWWIDTH, WINDOWHEIGH);
        GraphicsContext gcSpace = spaceCanvas.getGraphicsContext2D();

        Canvas shipCanvas = new Canvas(WINDOWWIDTH, WINDOWHEIGH);
        GraphicsContext gcShip = shipCanvas.getGraphicsContext2D();
  //      gcShip.setFill(Color.GREEN);
  //      gcShip.fillOval(50, 50, 20, 20);
        universe = new Space();
  
        stage.addEventHandler(KeyEvent.KEY_PRESSED,
                new EventHandler<KeyEvent>() {
            public void handle(
                    final KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.LEFT) {
                    universe.getSpaceShip().moveToTheLeft();
                }
                if (keyEvent.getCode() == KeyCode.RIGHT) {
                    universe.getSpaceShip().moveToTheRight();
                }
            }
        });

        gameInfiniteLoop(gcSpace, gcShip, universe, stage);

        root.getChildren().add(spaceCanvas);
        root.getChildren().add(shipCanvas);
        shipCanvas.toFront();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void gameInfiniteLoop(final GraphicsContext graphicalContextSpace, final GraphicsContext graphicalContextShip, final Space universe, final Stage stage) {
        SpaceShip.setUpGlobalWindowCoords(stage.getX(), stage.getY());
        universe.drawSpaceAndAllMeteoritsInSpace(graphicalContextSpace, graphicalContextShip);
        universe.moveAllMeteorits();
        universe.generateMeteorit();

        final Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameInfiniteLoop(graphicalContextSpace, graphicalContextShip, universe, stage);
            }
        }));
        timeline.play();
    }

}
