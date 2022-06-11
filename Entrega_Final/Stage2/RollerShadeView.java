import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class RollerShadeView extends Group {
    public RollerShadeView(double maxLength, double width, double length, double radius, Color color) {
        Rectangle background = new Rectangle(5,5, width-10,maxLength-5);
        background.setFill(Color.GREEN);  // I chose Blue
        background.setStroke(Color.BLACK);
        getChildren().add(background);

        cloth = new Rectangle (5,5, width-10, length);
        cloth.setFill(color);
        cloth.setStroke(Color.BLACK);
        getChildren().add(cloth);

        // Rolled up shade cloth
        Rectangle motor = new Rectangle(5,0, width-radius-5,radius*2);
        Ellipse leftSide = new Ellipse(5, radius,radius/2,radius);
        Ellipse rightSide = new Ellipse(width-5, radius,radius/2,radius);
        rightSide.setFill(color);
        motor.setFill(color);
        leftSide.setFill(color);
        rightSide.setStroke(Color.BLACK);
        motor.setStroke(Color.BLACK);
        leftSide.setStroke(Color.BLACK);
        getChildren().add(rightSide);
        getChildren().add(motor);
        getChildren().add(leftSide);

    }
    public void setLength(double length) {
        cloth.setHeight(length);
    }
    private Rectangle cloth;
}
