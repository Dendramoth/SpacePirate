/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Jakub
 */
public abstract class SpaceObject {
    protected int possitionX;
    protected int possitionY;
    protected int radius;
    protected int velocity;
        
    public SpaceObject (int possitionX, int possitionY, int radius,int velocity) {
        this.possitionX = possitionX;
        this.possitionY = possitionY;
        this.radius = radius;
        this.velocity = velocity;
    }
            
    public void moveObject () {
        possitionY = possitionY + velocity; 
    }
    
    public abstract void draw (GraphicsContext gc) ;
        
    
}
