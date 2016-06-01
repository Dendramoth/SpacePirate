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
import javafx.scene.transform.Rotate;
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
            3.0 + possitionX - 32, 28.0 + possitionY - 32,
            5.0 + possitionX - 32, 55.0 + possitionY - 32,
            7.0 + possitionX - 32, 50.0 + possitionY - 32,
            20.0 + possitionX - 32, 64.0 + possitionY - 32,
            42.0 + possitionX - 32, 64.0 + possitionY - 32,
            55.0 + possitionX - 32, 50.0 + possitionY - 32,
            59.0 + possitionX - 32, 55.0 + possitionY - 32,
            61.0 + possitionX - 32, 28.0 + possitionY - 32,
            57.0 + possitionX - 32, 28.0 + possitionY - 32,
            57.0 + possitionX - 32, 40.0 + possitionY - 32,
            40.0 + possitionX - 32, 44.0 + possitionY - 32,
            40.0 + possitionX - 32, 10.0 + possitionY - 32,
            36.0 + possitionX - 32, 0.0 + possitionY - 32,
            28.0 + possitionX - 32, 0.0 + possitionY - 32,
            24.0 + possitionX - 32, 10.0 + possitionY - 32,
            24.0 + possitionX - 32, 44.0 + possitionY - 32,
            7.0 + possitionX - 32, 40.0 + possitionY - 32,
            5.0 + possitionX - 32, 28.0 + possitionY - 32,
            3.0 + possitionX - 32, 28.0 + possitionY - 32});
        
            polygon.setRotate(angle);
    }

    public void drawPolygon(GraphicsContext palete) {
        double[] xPoints = {
            3 + possitionX - 32, 5 + possitionX - 32, 7 + possitionX - 32, 20 + possitionX - 32, 42 + possitionX - 32, 55 + possitionX - 32, 59 + possitionX - 32, 61 + possitionX - 32, 57 + possitionX - 32, 57 + possitionX - 32, 40 + possitionX - 32, 40 + possitionX - 32, 36 + possitionX - 32, 28 + possitionX - 32, 24 + possitionX - 32, 24 + possitionX - 32, 7 + possitionX - 32, 5 + possitionX - 32, 3 + possitionX - 32,};
        double[] yPoints = {
            28 + possitionY - 32, 55 + possitionY - 32, 50 + possitionY - 32, 64 + possitionY - 32, 64 + possitionY - 32, 50 + possitionY - 32, 55 + possitionY - 32, 28 + possitionY - 32, 28 + possitionY - 32, 40 + possitionY - 32, 44 + possitionY - 32, 10 + possitionY - 32, 0 + possitionY - 32, 0 + possitionY - 32, 10 + possitionY - 32, 44 + possitionY - 32, 40 + possitionY - 32, 28 + possitionY - 32, 28 + possitionY - 32
        };
        palete.setFill(Color.CRIMSON);
        palete.fillPolygon(xPoints, yPoints, 19);
    }

    public Polygon getPolygon() {
        return polygon;
    }

}
