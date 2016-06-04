/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author Dendra
 */
public class Rocket extends SpaceObjectWithColision{
    private double angleOfFiredRocket = 0;

    public Rocket(double possitionX, double possitionY, int radius, int velocity) {
        super(possitionX, possitionY, radius, velocity);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.AZURE);
        gc.fillOval(possitionX, possitionY, radius, radius);
    }
    
    @Override
    public boolean colisionDetection(Polygon spaceShipPolygon) {
        Circle meteorPolygon = new Circle(possitionX+ radius / 2, possitionY + radius / 2, (radius / 2)); 
        Shape intersect = Shape.intersect(spaceShipPolygon, meteorPolygon);
        if (intersect.getLayoutBounds().getHeight() <= 0 || intersect.getLayoutBounds().getWidth() <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public void moveObject() {
        possitionY = possitionY + velocity;
    }
    
    
}
