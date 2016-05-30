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

    public SpaceShip(int possitionX, int possitionY, int radius, int velocity) {
        super(possitionX, possitionY, radius, velocity);
        shipImage = LoadAllImages.mapOfAllImages.get("ship");
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        gc.translate(possitionX, possitionY );
        gc.rotate(angle);
        gc.drawImage(shipImage, - shipImage.getWidth()/2 , - shipImage.getHeight()/2);
        gc.restore();
    }

    private double calculateAngleForDrawingRotatedShip(double x, double y) {
        if (y == 0 && x == 0) {
            angle = 0;
        } else {
            if (y > 0) {
                angle = Math.toDegrees(Math.acos(x / (Math.sqrt(y * y + x * x)))) + 90;
                    System.out.println(angle);
            } else {
                angle = -Math.toDegrees(Math.acos(x / (Math.sqrt(y * y + x * x)))) + 90;
            
            }
            

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

        xMovement = xMovement / 15;
        yMovement = yMovement / 15;

        //       possitionX = possitionX + xMovement;
        //       possitionY = possitionY + yMovement;
        calculateAngleForDrawingRotatedShip(xMovement, yMovement);
        controlWindowBounds();
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

}
