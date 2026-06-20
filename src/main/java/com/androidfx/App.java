package com.androidfx;

import com.androidfx.components.BottomBar;
import com.androidfx.components.Card;
import com.androidfx.utilities.Backgrounds;
import com.androidfx.utilities.CubicBezier;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    double screenWidth = 300;
    double screenHeight = 600;

    boolean isAndroid = true;
    @Override
    public void start(Stage stage) {
        if(isAndroid){
            screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
            screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        }

        var root = new StackPane();
        root.setAlignment(Pos.CENTER);

        Card card = new Card(screenWidth,screenHeight);
        Label label = new Label("Hello, Android");
        label.setFont(new Font(25));
        card.getChildren().add(label);
        root.setPadding(new Insets(10));
        BottomBar bottomBar = new BottomBar(screenWidth,screenHeight);
        Button button = new Button("+");
        var buttonBg = new Background(new BackgroundFill(Color.ORANGERED,new CornerRadii(10), Insets.EMPTY));
        button.setBackground(buttonBg);
        bottomBar.getChildren().add(button);

        Button actionButton = new Button("Click me!");

        Rectangle rect = new Rectangle(80,60);
        rect.setArcWidth(20);
        rect.setArcHeight(20);

        TranslateTransition t = new TranslateTransition(Duration.millis(350),rect);
        t.setFromX(0);
        t.setToX(150);
        t.setInterpolator(new CubicBezier(0.42,1.67,0.21,0.9));
        t.setAutoReverse(true);
        t.setCycleCount(2);
        actionButton.setOnAction(e->t.playFromStart());

        card.getChildren().addAll(actionButton,rect);
        card.setSpacing(10);

        root.getChildren().addAll(card,bottomBar);
        StackPane.setAlignment(bottomBar,Pos.BOTTOM_CENTER);
        StackPane.setMargin(button,new Insets(5));
        root.setBackground(Backgrounds.fill(Color.IVORY));


        var scene = new Scene(root,screenWidth,screenHeight);
        scene.getStylesheets().add(App.class.getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(App.class);
    }
}
