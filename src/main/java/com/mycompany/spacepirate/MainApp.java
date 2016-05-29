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

public class MainApp extends Application {

    
    Space universe = new Space();
    LoadAllImages loadAllImages = new LoadAllImages();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Pirate");
        
        Pane root = new Pane();
        Canvas canvas = new Canvas(640, 860);

        GraphicsContext gc = canvas.getGraphicsContext2D();

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
        
        
  //      graphicalContext.drawImage(image,100,100);
        
        startGame(gc, universe, stage);

        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();
    //    stage.setResizable(true);
        
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

    private void startGame(final GraphicsContext graphicalContext, final Space universe, final Stage stage) {
        SpaceShip.setUpGlobalWindowCoords(stage.getX(), stage.getY());
        universe.drawSpaceAndAllMeteoritsInSpace(graphicalContext);
        universe.moveAllMeteorits();
        universe.generateMeteorit();

        final Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                startGame(graphicalContext, universe, stage);
            }
        }));
        timeline.play();
    }

}
