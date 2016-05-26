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


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Pirate");
        Group root = new Group();
        Canvas canvas = new Canvas(640, 860);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Space universe = new Space();
        startGame(gc, universe);
        
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
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

    private void startGame(final GraphicsContext graphicalContext, final Space universe) {
        universe.drawSpaceAndAllMeteoritsInSpace(graphicalContext);
        universe.moveAllMeteorits();
        universe.generateMeteorit();
        
         final Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                startGame(graphicalContext, universe);
            }
         }));
         timeline.play();
    }

}
