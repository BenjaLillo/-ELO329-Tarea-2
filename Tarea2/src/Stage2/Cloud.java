import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
        rollerShades = new ArrayList<RollerShade>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public void addRollerShade(RollerShade rs){ //Método creado
        rollerShades.add(rs);
    }

    public RollerShade getShadeAtChannel(int channel){
        for (RollerShade rs: rollerShades)
            if (rs.getChannel() ==channel)
                return rs;
        return null;
    }

    public void startShadeUp(int channel){ //Método creado
        RollerShade rs = getShadeAtChannel(channel);
        if (rs != null) rs.startUp();
    }
    public void startShadeDown(int channel){    //Método creado
        RollerShade rs = getShadeAtChannel(channel);
        if (rs != null) rs.startDown();
    }
    public void stopShade(int channel){
        RollerShade rs = getShadeAtChannel(channel);
        if (rs != null) rs.stop();
    }
    public Lamp getLampAtChannel( int channel){
        for (Lamp l: lamps)
            if (l.getChannel() ==channel)
                return l;
        return null;
    }
    public void changeLampPowerState(int channel){
        Lamp l=getLampAtChannel(channel);
        if (l != null) l.changePowerState();
    }
    private ArrayList<Lamp> lamps;
    private ArrayList<RollerShade> rollerShades;    //Creada para Stage 2
}
