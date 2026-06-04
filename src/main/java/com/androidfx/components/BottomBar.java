package com.androidfx.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BottomBar extends HBox {
    public BottomBar(double screenWidth,double screenHeight){
        this.setSpacing(5);
        this.setPadding(new Insets(10));
        var backgroundColor = Color.BLACK;
        var backgroundRadius = new CornerRadii(20);
        this.setBackground(new Background(new BackgroundFill(backgroundColor,backgroundRadius,Insets.EMPTY)));
        this.setMaxWidth(screenWidth-10);
        this.setMaxHeight(screenHeight*0.01);
        this.setAlignment(Pos.CENTER);
    }

}
