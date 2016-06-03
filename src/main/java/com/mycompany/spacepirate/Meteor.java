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
        gc.setFill(Color.CHOCOLATE);
     //   gc.fillOval(possitionX - radius, possitionY - radius, radius , radius);
        
        gc.drawImage(meteorImage1, possitionX, possitionY, radius, radius);
    }
    
    
}
