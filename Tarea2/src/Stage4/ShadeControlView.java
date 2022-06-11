

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.ArrayList;

public class ShadeControlView extends BorderPane {
    //public ShadeControlView (ShadeControl sc){
    public ShadeControlView (ShadeControl sc){
        ShadeControl shadeControl = sc;
        StackPane stack = new StackPane();

        Image flecha_up = new Image("rsc/flecha-arriba.png");
        Image flecha_down = new Image("rsc/flecha-abajo.png");
        Image flecha_right = new Image("rsc/flecha-correcta.png");
        Image flecha_left = new Image("rsc/flecha-izquierda.png");
        ImageView up = new ImageView(flecha_up);
        ImageView down = new ImageView(flecha_down);
        ImageView right = new ImageView(flecha_right);
        ImageView left = new ImageView(flecha_left);

        Button channelButton_stop = new Button(""+sc.getChannel());

        up.setOnMouseClicked( e-> sc.startUp());
        down.setOnMouseClicked( e-> sc.startDown());
        right.setOnMouseClicked( e-> {sc.nextChannel(sc.getChannel());
            channelButton_stop.setText(""+sc.getChannel());
        });
        left.setOnMouseClicked( e-> {
            sc.prevChannel(sc.getChannel());
            channelButton_stop.setText(""+sc.getChannel());

        });
        channelButton_stop.setOnAction( e-> sc.stop());

        Rectangle botonera = new Rectangle(100,100, Color.LIGHTGRAY);
        botonera.setStroke(Color.BLACK);

        stack.getChildren().addAll(botonera, up, down, right, left, channelButton_stop);

        stack.setMargin(up, new Insets(0,0,50,0));
        stack.setMargin(down, new Insets(50,0,0,0));
        stack.setMargin(right, new Insets(0,0,0,50));
        stack.setMargin(left, new Insets(0,50,0,0));
        stack.setAlignment(channelButton_stop, Pos.CENTER);
        setCenter(stack);

    }

}