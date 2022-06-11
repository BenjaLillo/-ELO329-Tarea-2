

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Stage2 extends Application {
    public void start(Stage primaryStage) {
        Cloud cloud = new Cloud();
        Lamp lamp2 = new Lamp(2);
        Lamp lamp3 = new Lamp(3);
        LampControl lampControl2 = new LampControl(2, cloud);
        LampControl lampControl3 = new LampControl(3, cloud);
        ArrayList<LampControl> lampcontrol_list = new ArrayList<>();
        cloud.addLamp(lamp2);
        cloud.addLamp(lamp3);
        //SE CREA UNA LISTA DE LAS LAMPARAS PARA DARSELO A LA VISTA DEL CONTROL
        lampcontrol_list.add(lampControl2);
        lampcontrol_list.add(lampControl3);
        //SE CREA UNA HBOX Y SE INSERTA LAS LAMPARAS Y EL CONTROL
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lamp2.getView(), lamp3.getView(), new LampControlView(lampcontrol_list)); //¿se podrá así?
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        pane.setBottom(hBox);
        int shadeChannel=2;
        RollerShade rs = new RollerShade(shadeChannel, 2, 150, 100);
        cloud.addRollerShade(rs);
        pane.setCenter(rs.getView());
        ShadeControl shadeControl = new ShadeControl(shadeChannel,cloud);
        hBox.getChildren().add(0,shadeControl.getView());
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
