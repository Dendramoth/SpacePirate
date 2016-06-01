/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author Jakub
 */
public abstract class SpaceObjectWithColision extends SpaceObject {

    public SpaceObjectWithColision(int possitionX, int possitionY, int radius, int velocity) {
        super(possitionX, possitionY, radius, velocity);
    }

    public boolean colisionDetection(Polygon spaceShipPolygon) { // collision detection should be based on the polygons created just for detection purposes
        Circle meteorPolygon = new Circle(possitionX+ radius / 2, possitionY + radius / 2, (radius / 2) - 3); // -5 is here because the meteorits have not totally round shape and we dont want the player to be "hit" when he is not supposed to
        Shape intersect = Shape.intersect(spaceShipPolygon, meteorPolygon);
        if (intersect.getLayoutBounds().getHeight() <= 0 || intersect.getLayoutBounds().getWidth() <= 0) {
            return false;
        }
        return true;
    }

}
