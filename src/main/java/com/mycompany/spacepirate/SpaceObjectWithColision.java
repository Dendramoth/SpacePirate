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

    public SpaceObjectWithColision(double possitionX, double possitionY, int radius, int velocity) {
        super(possitionX, possitionY, radius, velocity);
    }

    public abstract boolean colisionDetection(Polygon spaceShipPolygon);

}
