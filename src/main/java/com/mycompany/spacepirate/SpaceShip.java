/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Jakub
 */
public class SpaceShip extends SpaceObjectWithColision {

    public SpaceShip(int possitionX, int possitionY, int radius, int velocity) {
        super(possitionX, possitionY, radius, velocity);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.AQUA);
        gc.fillRect(possitionX, possitionY, radius, radius);
    }
    
    public void moveToTheLeft () {
        possitionX = possitionX - velocity ;
    }
    
    public void moveToTheRight () {
        possitionX = possitionX + velocity ;
    }
    
    
    
}
