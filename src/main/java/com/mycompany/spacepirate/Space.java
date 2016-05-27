/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

import java.util.ArrayList;
import java.util.Iterator;
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

    private int timeToGenerateMeteorit = 50;
    private List<Meteor> listOfAllMeteorits = new ArrayList<Meteor>();
    Random random = new Random();
    private SpaceShip spaceShip = new SpaceShip(310, 800, 20, 5);

    public Space() {

    }

    public void drawSpaceAndAllMeteoritsInSpace(GraphicsContext gc) {
        gc.setFill(Color.GREY);
        gc.fillRect(0, 0, 640, 860); // draw Space 

        for (Meteor meteor : listOfAllMeteorits) {
            meteor.draw(gc);
        }
        
        spaceShip.draw(gc);
    }

    public void moveAllMeteorits() {
        Iterator<Meteor> iterator = listOfAllMeteorits.iterator();
        while (iterator.hasNext()) {
            Meteor meteor = iterator.next();
            meteor.moveObject();
            if (meteor.getPossitionY() > 1000) {
                iterator.remove();
            }
        }

    }

    public void generateMeteorit() {
        timeToGenerateMeteorit--;
        if (timeToGenerateMeteorit < 1) {
            timeToGenerateMeteorit = 50;
            listOfAllMeteorits.add(new Meteor(random.nextInt(640), -50, random.nextInt(90) + 10, random.nextInt(5) + 1));
        }
    }

    public SpaceShip getSpaceShip() {
        return spaceShip;
    }
    
   
    
}
