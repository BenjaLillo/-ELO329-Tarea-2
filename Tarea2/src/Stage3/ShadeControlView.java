

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

public class ShadeControlView extends BorderPane {
    public ShadeControlView (ShadeControl sc){
        ShadeControl shadeControl = sc;
        StackPane stack = new StackPane();

        Image flecha_up = new Image("rsc/flecha-arriba.png");
        Image flecha_down = new Image("rsc/flecha-abajo.png");
        ImageView up = new ImageView(flecha_up);
        ImageView down = new ImageView(flecha_down);

        //Button channelButton_up = new Button("up");
        //Button channelButton_down = new Button("down");
        Button channelButton_stop = new Button(""+sc.getChannel());

        up.setOnMouseClicked( e-> sc.startUp());
        down.setOnMouseClicked( e-> sc.startDown());
        channelButton_stop.setOnAction( e-> sc.stop());

        Rectangle botonera = new Rectangle(100,100, Color.LIGHTGRAY);
        botonera.setStroke(Color.BLACK);

        stack.getChildren().addAll(botonera, up, down, channelButton_stop);

        stack.setMargin(up, new Insets(0,0,50,0));
        stack.setMargin(down, new Insets(50,0,0,0));
        stack.setAlignment(channelButton_stop, Pos.CENTER);
        setCenter(stack);

    }
}