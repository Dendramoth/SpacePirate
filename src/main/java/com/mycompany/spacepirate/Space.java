/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

/**
 *
 * @author Dendra
 */
public class Space {
    int timeToGenerateMeteorit = 50;
    List<SpaceObjectWithColision> listOfAllMeteorits = new ArrayList<SpaceObjectWithColision>();
    Random random = new Random();
    
    public Space(){
        
    }
    
    public void drawSpaceAndAllMeteoritsInSpace(GraphicsContext gc){
        gc.setFill(Color.GREY);
        gc.fillRect(0, 0, 640, 860); // draw Space 
        
        for (SpaceObjectWithColision spaceObjectWithColision : listOfAllMeteorits){
            spaceObjectWithColision.draw(gc);
        }
    }
    
    public void moveAllMeteorits(){
        for (SpaceObjectWithColision spaceObjectWithColision : listOfAllMeteorits){
            spaceObjectWithColision.moveObject();
            if (spaceObjectWithColision.getPossitionY() > 1000){
         //       listOfAllMeteorits.remove(spaceObjectWithColision);
            }
        }
    }
    
    public void generateMeteorit(){
        timeToGenerateMeteorit--;
        if (timeToGenerateMeteorit < 1){
            timeToGenerateMeteorit = 50;
            listOfAllMeteorits.add(new SpaceObjectWithColision(random.nextInt(600)+100, -50, random.nextInt(90)+10, random.nextInt(5)+1));
        }
    }
}
