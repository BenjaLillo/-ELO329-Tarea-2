

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Stage4 extends Application {
    public void start(Stage primaryStage) {
        /* SE CREA LA NUBE, SE INICIAN LAS LÁMPARAS Y SUS CONTROLES*/
        Cloud cloud = new Cloud();
        Lamp lamp2 = new Lamp(2);
        Lamp lamp3 = new Lamp(3);
        LampControl lampControl2 = new LampControl(2, cloud);
        LampControl lampControl3 = new LampControl(3, cloud);

        //SE CREA UNA LISTA DE LAS LAMPARAS PARA DARSELO A LA VISTA DEL CONTROL
        ArrayList<LampControl> lampcontrol_list = new ArrayList<>();
        cloud.addLamp(lamp2);
        cloud.addLamp(lamp3);
        lampcontrol_list.add(lampControl2);
        lampcontrol_list.add(lampControl3);

        //SE CREA UNA HBOX Y SE INSERTA LAS LAMPARAS Y EL CONTROL*/
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lamp2.getView(), lamp3.getView(), new LampControlView(lampcontrol_list)); //¿se podrá así?


        /* SE INICIA LA CORTINA Y SE AGREGA A LA NUBE */
        int shadeChannel=4;
        int shadeChannel2=5;
        RollerShade rs = new RollerShade(shadeChannel, 2, 150, 100);
        RollerShade rs2 = new RollerShade(shadeChannel2, 2, 150, 100);
        ArrayList<Integer> shadecontrol_list = new ArrayList<>();
        shadecontrol_list.add(shadeChannel);
        shadecontrol_list.add(shadeChannel2);
        cloud.addRollerShade(rs);
        cloud.addRollerShade(rs2);

        /* SE CREA EL CONTROL DE LA CORTINA Y SE UBICA EN LA HBOX ANTERIORMENTE USADA*/
        HBox hBox2 = new HBox(20);
        hBox2.setPadding(new Insets(20));
        hBox2.setAlignment(Pos.CENTER);
        ShadeControl shadeControl = new ShadeControl(shadecontrol_list.get(0) ,cloud, shadecontrol_list);
        hBox2.getChildren().addAll(rs.getView(), rs2.getView());
        hBox.getChildren().add(0,shadeControl.getView());

        /* SE CREA UN "PANE" Y SE INSERTA LA CORTINA*/
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        pane.setBottom(hBox);
        pane.setCenter(hBox2);


        /* SE ORDENA LA ESCENA*/
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
