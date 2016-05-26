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


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Pirate");
        Group root = new Group();
        Canvas canvas = new Canvas(640, 860);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        SpaceObjectWithColision meteor = createMeteor(gc, 400, 100, 30, 10);
        startGame(gc, meteor);
        
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

    private void startGame(final GraphicsContext gc,final SpaceObjectWithColision meteor) {
        drawSpace(gc);
        meteor.draw(gc);
        meteor.moveObject();
         final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                startGame(gc, meteor);
            }
         }));
    }
    
    private void drawSpace(GraphicsContext gc) {
        gc.setFill(Color.GREY);
        gc.fillRect(0, 0, 640, 860); // draw Space 
    }

    private SpaceObjectWithColision createMeteor (GraphicsContext gc, int possX, int possY, int radius, int velocity){
        SpaceObjectWithColision newMeteor = new SpaceObjectWithColision(possX, possY, radius, velocity);
        return newMeteor;
    }
    

}
