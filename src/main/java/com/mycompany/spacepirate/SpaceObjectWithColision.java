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
public class SpaceObjectWithColision extends SpaceObject{
    
    public SpaceObjectWithColision (int possitionX, int possitionY, int radius,int velocity){
        super(possitionX, possitionY, radius, velocity);
        
    }
    public boolean ColidedOrNotToColidedThatsTheQuestion (int possitionXRightOfSpaceship, int possitionYUpOfSpaceship, int possitionXLeftOfSpaceship, int possitionYDownOfSpaceship){
        return false;
    }
}
