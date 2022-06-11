

import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class ShadeControl extends DomoticDeviceControl{
    public ShadeControl(int channel, Cloud c, ArrayList<Integer> channelList){
        super(channel,c);
        view = new ShadeControlView(this);
        this.channelList = channelList;
        System.out.println(channelList);
    }
    public BorderPane getView() {return view;}
    public void startUp(){
        cloud.startShadeUp(getChannel());
    }
    public void startDown(){
        cloud.startShadeDown(getChannel());
    }
    public void stop(){
        cloud.stopShade(getChannel());
    }
    public void nextChannel(int channel){
        for (int c:channelList){
            if (c == channel){
                int index = channelList.indexOf(channel);
                System.out.println(channelList.size());

                index= index + 1;
                if (index > channelList.size()-1){
                    index = channelList.size()-1;
                }
                setChannel(channelList.get(index));
            }

        }
    }
    public void prevChannel(int channel){
        for (int c:channelList){
            if (c == channel){
                int index = channelList.indexOf(channel);
                System.out.println(index);
                index= index - 1;
                if (index < 0){
                    index = 0;
                }
                setChannel(channelList.get(index));
            }

        }
    }


    private ShadeControlView view;
    ArrayList<Integer> channelList;
}