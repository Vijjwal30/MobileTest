package com.androidfx;

import com.androidfx.components.BottomBar;
import com.androidfx.components.Card;
import com.androidfx.utilities.Backgrounds;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    final double screenWidth = 300;
    final double screenHeight = 600;
    @Override
    public void start(Stage stage) {
        var root = new StackPane();
        root.setAlignment(Pos.TOP_CENTER);

        Card card = new Card(screenWidth,screenHeight);
        Label label = new Label("Hello, Android");
        label.setFont(new Font(25));
        card.getChildren().add(label);
        root.setPadding(new Insets(10));
        BottomBar bottomBar = new BottomBar(screenWidth,screenHeight);
        Button button = new Button("+");
        button.setBackground(new Background(new BackgroundFill(Color.ORANGERED,new CornerRadii(10), Insets.EMPTY)));
        bottomBar.getChildren().add(button);

        root.getChildren().addAll(card,bottomBar);
        StackPane.setAlignment(bottomBar,Pos.BOTTOM_CENTER);
        StackPane.setMargin(button,new Insets(5));
        root.setBackground(Backgrounds.fill(Color.IVORY));
        var scene = new Scene(root,screenWidth,screenHeight);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(App.class);
    }
}
