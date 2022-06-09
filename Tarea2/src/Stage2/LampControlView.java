import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LampControlView extends VBox {
    public LampControlView(LampControl lampControl) {
        Image img = new Image("rsc/power.png");
        ImageView view = new ImageView(img);
        // Código rellenado

        view.setOnMouseClicked(evento -> lampControl.pressPower());
        getChildren().addAll(view);
    }
}