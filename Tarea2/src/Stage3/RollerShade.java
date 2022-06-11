package src;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class RollerShade extends DomoticDevice {
    public RollerShade (int channel, double alpha, double width, double len) {
        super(channel);
        motor = new Motor(alpha);
        MaxShadeLength = len;
        this.length = 0;  // Start with roller shade open.
        view = new RollerShadeView(MaxShadeLength, width, length, RADIUS, Color.GRAY);
    }
    public Group getView() { return view;}
    public void startUp(){
        motor.turnUp();
    }
    public void startDown(){
        motor.turnDown();
    }
    public void stop(){
        motor.stop();
    }
    private class Motor implements EventHandler<ActionEvent> {  //nested class, Motor is only used within RollerShade.
        public Motor (double a){
            alpha = a;
            state = MotorState.STOPPED;
            animation= new Timeline(new KeyFrame(Duration.millis(DELTA*1000), this));
            animation.setCycleCount(Timeline.INDEFINITE);
        }


        public void turnUp(){
            state = MotorState.UPWARD;
            animation.play();
        }
        public void turnDown(){
            state = MotorState.DOWNWARD;
            animation.play();
        }
        public void stop(){
            state = MotorState.STOPPED;
            animation.stop();
        }
        public void handle (ActionEvent event){
            double increment = alpha*DELTA*RADIUS;
            switch (state) {
                case STOPPED: break;
                case DOWNWARD:
                    if(length <= MaxShadeLength-5)
                        length =  length + increment;
                    else
                        state = MotorState.STOPPED;
                    break;
                case UPWARD:
                    if(length == 0)
                        state = MotorState.STOPPED;
                    else
                        length =  length - increment;
                    break;
            }
            view.setLength(length);
        }
        private double alpha;
        private MotorState state;
        private Timeline animation;
        private static final double DELTA=0.1;
    }
    private RollerShadeView view;
    private Motor motor;
    private double length;
    private final double MaxShadeLength;
    private static double RADIUS=4;  //cm
}