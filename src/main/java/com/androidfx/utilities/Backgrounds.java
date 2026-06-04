package com.androidfx.utilities;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Backgrounds {
    public static Background fill(Color color){
        return new Background(new BackgroundFill(color,null,null));
    }
}
