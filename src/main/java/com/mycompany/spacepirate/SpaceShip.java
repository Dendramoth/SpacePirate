/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

import java.awt.MouseInfo;
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Window;

/**
 *
 * @author Jakub
 */
public class SpaceShip extends SpaceObjectWithColision {

    private static int windowPositionX;
    private static int windowPositionY;

    private Image shipImage;
    private double angle;
    private Polygon polygon;

    public SpaceShip(int possitionX, int possitionY, int radius, int velocity) {
        super(possitionX, possitionY, radius, velocity);
        shipImage = LoadAllImages.mapOfAllImages.get("ship");
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        gc.translate(possitionX, possitionY);
        gc.rotate(angle);
        gc.drawImage(shipImage, -shipImage.getWidth() / 2, -shipImage.getHeight() / 2);
        gc.restore();
    }

    private double calculateAngleForDrawingRotatedShip(double x, double y) {
        if (y == 0 && x == 0) {
            angle = 0;
        } else if (y > 0) {
            angle = Math.toDegrees(Math.acos(x / (Math.sqrt(y * y + x * x)))) + 90;
        } else {
            angle = -Math.toDegrees(Math.acos(x / (Math.sqrt(y * y + x * x)))) + 90;
        }
        return angle;
    }

    public void moveToTheLeft() {
        possitionX = possitionX - velocity;
    }

    public void moveToTheRight() {
        possitionX = possitionX + velocity;
    }

    public void moveToMouseCursor() {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        mouseLocation.getX();
        mouseLocation.getY();

        int xMovement = (int) Math.round(mouseLocation.getX()) - windowPositionX - possitionX - radius;
        int yMovement = (int) Math.round(mouseLocation.getY()) - windowPositionY - possitionY - radius;

        calculateAngleForDrawingRotatedShip(xMovement, yMovement);

        xMovement = xMovement / 25;
        yMovement = yMovement / 25;

        possitionX = possitionX + xMovement;
        possitionY = possitionY + yMovement;

        controlWindowBounds();
        preparePolygonForColisionDetection();
    }

    private void controlWindowBounds() {
        if (possitionX < 0) {
            possitionX = 0;
        }
        if (possitionX > 580) {
            possitionX = 580;
        }
        if (possitionY < 0) {
            possitionY = 0;
        }
        if (possitionY > 800) {
            possitionY = 800;
        }
    }

    public static void setUpGlobalWindowCoords(Double globalX, Double globalY) {
        windowPositionX = (int) Math.round(globalX);
        windowPositionY = (int) Math.round(globalY);
    }

    private void preparePolygonForColisionDetection() {
        polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            3.0 + possitionX, 28.0 + possitionY,
            5.0 + possitionX, 55.0 + possitionY,
            7.0 + possitionX, 50.0 + possitionY,
            20.0 + possitionX, 64.0 + possitionY,
            42.0 + possitionX, 64.0 + possitionY,
            55.0 + possitionX, 50.0 + possitionY,
            59.0 + possitionX, 55.0 + possitionY,
            61.0 + possitionX, 28.0 + possitionY,
            57.0 + possitionX, 28.0 + possitionY,
            57.0 + possitionX, 40.0 + possitionY,
            40.0 + possitionX, 44.0 + possitionY,
            40.0 + possitionX, 10.0 + possitionY,
            36.0 + possitionX, 0.0 + possitionY,
            28.0 + possitionX, 0.0 + possitionY,
            24.0 + possitionX, 10.0 + possitionY,
            24.0 + possitionX, 44.0 + possitionY,
            7.0 + possitionX, 40.0 + possitionY,
            5.0 + possitionX, 28.0 + possitionY,
            3.0 + possitionX, 28.0 + possitionY});
    }
    
    public void drawPolygon(GraphicsContext palete) {
        double[] xPoints = {
            3 + possitionX, 5 + possitionX, 7 + possitionX, 20 + possitionX, 42 + possitionX, 55 + possitionX, 59 + possitionX, 61 + possitionX, 57 + possitionX, 57 + possitionX , 40 + possitionX , 40 + possitionX , 36 + possitionX , 28 + possitionX , 24 + possitionX , 24 + possitionX , 7 + possitionX , 5 + possitionX , 3 + possitionX,
        };
        double[] yPoints = {
            28 + possitionY, 55 + possitionY, 50 + possitionY, 64 + possitionY, 64 + possitionY, 50 + possitionY, 55 + possitionY, 28 + possitionY, 28 + possitionY, 40 + possitionY, 44 + possitionY , 10 + possitionY , 0 + possitionY , 0 + possitionY , 10 + possitionY , 44 + possitionY , 40 + possitionY , 28 + possitionY, 28 + possitionY 
        };
        palete.setFill(Color.CRIMSON);
        palete.fillPolygon(xPoints, yPoints, 19);
    }

    public Polygon getPolygon() {
        return polygon;
    }
    
    

}
