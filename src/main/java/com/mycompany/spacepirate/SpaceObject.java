/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

/**
 *
 * @author Jakub
 */
public class SpaceObject {
    private int possitionX;
    private int possitionY;
    private int radius;
    private int velocity;
        
    public SpaceObject (int possitionX, int possitionY, int radius,int velocity) {
        this.possitionX = possitionX;
        this.possitionY = possitionY;
        this.radius = radius;
        this.velocity = velocity;
    }
            
    public void moveObject () {
        possitionY = possitionY + velocity; 
    }
    
    public void draw () {
        
    }
}
