import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class LampView extends Group {
    private Polygon lampshade;
    int r,g,b;

    public LampView () {
        Polygon base = new Polygon();
        Polygon head = new Polygon();

        base.getPoints().addAll(new Double[]{
                18d, 20d,
                18d, 50d,
                13d, 50d,
                10d, 53d,
                10d, 60d,
                30d, 60d,
                30d, 53d,
                27d, 50d,
                22d, 50d,
                22d, 20d});
        base.setFill(Color. rgb(r,g,b));

        head.getPoints().addAll(new Double[]{
                10d, 0d,
                30d, 0d,
                40d, 20d,
                0d, 20d
        });
        head.setFill(Color.GREEN);

        getChildren().addAll(base, head /* ¿? */);
    }
    public void setColor(short r, short g, short b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
