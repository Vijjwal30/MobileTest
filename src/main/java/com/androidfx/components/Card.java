package com.androidfx.components;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Card extends VBox {

    public Card(double screenWidth,double screenHeight){
        this.setPadding(new Insets(20));
        this.setMaxSize(screenWidth,0.4*screenHeight);
        var background = new BackgroundFill(Color.ALICEBLUE,new CornerRadii(20),Insets.EMPTY);
        this.setBackground(new Background(background));
    }
}
