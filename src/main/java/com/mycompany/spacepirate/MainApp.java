package com.mycompany.spacepirate;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Pirate");
        Group root = new Group();
        Canvas canvas = new Canvas(640, 860);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        startGame(gc);
        
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

    private void startGame(GraphicsContext gc) {
        drawSpace(gc);
    }
    
    private void drawSpace(GraphicsContext gc) {
        gc.setFill(Color.GREY);
        gc.fillRect(0, 0, 640, 860); // draw Space 
    }

    

}
