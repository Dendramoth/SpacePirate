/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spacepirate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author Dendra
 */
 public class LoadAllImages {
    static HashMap<String, Image> mapOfAllImages = new HashMap<String, Image>();

    public LoadAllImages() {
        Image image = new Image("/meteor1.png");
        mapOfAllImages.put("meteorOne", image);
        
        image = new Image("/meteor2.png");
        mapOfAllImages.put("meteorTwo", image);
    }

    public HashMap<String, Image> getMapOfAllImages() {
        return mapOfAllImages;
    }

   
    
}
