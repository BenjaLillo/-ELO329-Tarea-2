
import javafx.scene.layout.Pane;

public class LampControl extends DomoticDeviceControl{
    public LampControl(int channel, Cloud c){
        super(channel, c);  //Añadido dado que ahora LampControl extiende DomoticDeviceControl
        this.channel= channel;
        cloud = c;
        //view = new LampControlView(this);
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public int getChannel(){
        return channel;
    }
    //public Pane getView() { return view;}
    public void changeColorRed(short new_val){
        cloud.getLampAtChannel(channel).changeRed(new_val);
    }
    public void changeColorGreen(short new_val){
        cloud.getLampAtChannel(channel).changeGreen(new_val);
    }
    public void changeColorBlue(short new_val){
        cloud.getLampAtChannel(channel).changeBlue(new_val);
    }
    private int channel;
    private Cloud cloud;
    private Pane view;
}
