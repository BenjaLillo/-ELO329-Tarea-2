


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        int ch = 2; //SE INICIA EL CANAL CON EL QUE SE ESTÁ TRABAJANDO

        /* SE CREA LA IMAGEN Y SE CONFIGURA PARA QUE APAGE EL CONTROL CON EL CANAL ACTUAL */
        Image img = new Image("rsc/powerImage.jpg");
        ImageView view = new ImageView(img);
        view.setOnMouseClicked(evento -> lampcontrol_list.get(ch).pressPower()); //"lampcontrollist.get(ch)" se referirá al canal actual

        /* SE CREA EL SPINNER Y SE CONFIGURA PARA QUE ELIGA EL CANAL SEGÚN EL NÚMERO QUE SE MUESTRE */
        Label label = new Label("Seleccione canal:");
        final Spinner<Integer> spinner = new Spinner<Integer>(); //¿es necesario el final?
        final int initialValue = 2; //¿es necesario el final?
        SpinnerValueFactory<Integer> valueFactory = //no estoy seguro de esta implementación pero tiene sentido para mí, si no funciona implemento un listener no más
                new SpinnerValueFactory<Integer>() {
                    @Override
                    public void decrement(int steps) {
                        int current = this.getValue();
                        LampControlView.ch = current;
                    }
                    @Override
                    public void increment(int steps) {
                        int current = this.getValue();
                        LampControlView.ch = current;
                    }
        };
        spinner.setValueFactory(valueFactory);

        /* SE CREAN LOS SLIDERS Y SE CONFIGURAN PARA QUE CAMBIEN EL COLOR DE LA LAMPARA CORRESPONDIENTE */
        Slider redColor = new Slider();
        redColor.setMin(0);
        redColor.setMax(255);
        redColor.setValue(124);

        redColor.valueProperty().addListener((ov, old_val, new_val) -> { //se implementa un Listener que cambia el valor del color
            lampcontrol_list.get(ch).changeColorRed(new_val.shortValue());
        });

        /* SE CREA EL GRIDPANE Y SE ARMA EL CONTROL */
        GridPane gridPane = new GridPane(); //hay que hacer que se vea bien
        gridPane.setMinSize(200, 200);
        gridPane.setAlignment(Pos.BASELINE_RIGHT);
        gridPane.add(view,1,0);
        gridPane.add(spinner,1,1);
        getChildren().addAll(gridPane); //¿que hace esto?
    }



    static private int ch=2;
}