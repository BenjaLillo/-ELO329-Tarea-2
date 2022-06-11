

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Slider;
import javafx.geometry.Pos;
import java.util.ArrayList;

public class LampControlView extends VBox {
    /* Acá cree una vista del control que actúa como vista para ambas instancias de controles de lampara.
    * El constructor recibe una lista de objetos "LampControl" con el cual podrá decidir según el valor del
    * spinner a cual de los dos cambiar*/

    public LampControlView(ArrayList<LampControl> lampcontrol_list) {

        /* SE CREA LA IMAGEN Y SE CONFIGURA PARA QUE APAGE EL CONTROL CON EL CANAL ACTUAL */
        Image img = new Image("rsc/power.png");
        ImageView view = new ImageView(img);
        view.setOnMouseClicked(evento -> {
            lampcontrol_list.get(ch-2).pressPower();
        }); //"lampcontrollist.get(ch)" se referirá al canal actual

        /* SE CREA EL SPINNER Y SE CONFIGURA PARA QUE ELIGA EL CANAL SEGÚN EL NÚMERO QUE SE MUESTRE */
        Label label = new Label("Seleccione canal:");
        final Spinner<Integer> spinner = new Spinner<Integer>(); //¿es necesario el final?
        final int initialValue = 2; //¿es necesario el final?
        SpinnerValueFactory<Integer> valueFactory = //no estoy seguro de esta implementación pero tiene sentido para mí, si no funciona implemento un listener no más
                new SpinnerValueFactory.IntegerSpinnerValueFactory(2,3,initialValue);
        valueFactory.valueProperty().addListener((obs, oldValue, newValue) ->{
            System.out.println("Nuevo valor: " + newValue.shortValue() );
            LampControlView.ch = newValue.shortValue();
            System.out.println("Nuevo valor de 'ch': " + LampControlView.ch );
            }
        );
        spinner.setValueFactory(valueFactory);


        /* SE CREAN LOS SLIDERS Y SE CONFIGURAN PARA QUE CAMBIEN EL COLOR DE LA LAMPARA CORRESPONDIENTE */
        Slider redColorSlider = new Slider();
        redColorSlider.setMin(0);
        redColorSlider.setMax(255);
        redColorSlider.setValue(124);

        Slider greenColorSlider = new Slider();
        greenColorSlider.setMin(0);
        greenColorSlider.setMax(255);
        greenColorSlider.setValue(124);

        Slider blueColorSlider = new Slider();
        blueColorSlider.setMin(0);
        blueColorSlider.setMax(255);
        blueColorSlider.setValue(124);

        redColorSlider.valueProperty().addListener((ov, old_val, new_val) -> { //se implementa un Listener que cambia el valor del color
            lampcontrol_list.get(ch-2).changeColorRed(new_val.shortValue());
        });

        greenColorSlider.valueProperty().addListener((ov, old_val, new_val) -> { //se implementa un Listener que cambia el valor del color
            lampcontrol_list.get(ch-2).changeColorGreen(new_val.shortValue());
        });

        blueColorSlider.valueProperty().addListener((ov, old_val, new_val) -> { //se implementa un Listener que cambia el valor del color
            lampcontrol_list.get(ch-2).changeColorBlue(new_val.shortValue());
        });


        /* VBOX PARA LOS SLIDERS */
        VBox sliders_view = new VBox(5);
        sliders_view.getChildren().addAll(redColorSlider, greenColorSlider, blueColorSlider);
        /* SE CREA EL GRIDPANE Y SE ARMA EL CONTROL */
        GridPane gridPane = new GridPane(); //hay que hacer que se vea bien
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(70);
        gridPane.setMinSize(200, 200);
        gridPane.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(view,1,0);
        gridPane.setHalignment(view, HPos.CENTER);
        gridPane.add(spinner,1,1);
        gridPane.add(sliders_view,1,2);
        getChildren().addAll(gridPane); //¿que hace esto?
    }



    static private int ch=2;
}