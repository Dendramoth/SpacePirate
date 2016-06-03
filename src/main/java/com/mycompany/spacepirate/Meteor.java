/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

import java.io.File;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author Jakub
 */
public class Meteor extends SpaceObjectWithColision {
    private Image meteorImage1;
    
    public Meteor(double possitionX, double possitionY, int radius, int velocity, Image meteor1) {
        super(possitionX, possitionY, radius, velocity);
        this.meteorImage1 = meteor1;
    }
    
    @Override
    public void draw(GraphicsContext gc) {
     //   gc.setFill(Color.CHOCOLATE);
     //   gc.fillOval(possitionX - radius, possitionY - radius, radius , radius);
        
        gc.drawImage(meteorImage1, possitionX, possitionY, radius, radius);
    }
    
    @Override
    public boolean colisionDetection(Polygon spaceShipPolygon) { // collision detection should be based on the polygons created just for detection purposes
        Circle meteorPolygon = new Circle(possitionX+ radius / 2, possitionY + radius / 2, (radius / 2) - 3); // -5 is here because the meteorits have not totally round shape and we dont want the player to be "hit" when he is not supposed to
        Shape intersect = Shape.intersect(spaceShipPolygon, meteorPolygon);
        if (intersect.getLayoutBounds().getHeight() <= 0 || intersect.getLayoutBounds().getWidth() <= 0) {
            return false;
        }
        return true;
    }
    
    
}
