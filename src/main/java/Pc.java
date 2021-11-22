import java.util.ArrayList;

public class Pc {

    private boolean switchedOn;
    ArrayList<Cable> cables = new ArrayList<Cable>();

    public boolean isSwitchedOn(){
        return this.switchedOn;
    }
    public void setSwitchedOn(boolean switchedOn){
        this.switchedOn = switchedOn;
    }
    public void switchOn(){
        switchedOn = true;
    }

    public ArrayList<Cable> getCables(){
        return cables;
    }
    public void setCables(ArrayList<Cable> cables){
        this.cables = cables;
    }


    Pc pc1 = new Pc();
    Pc pc2 = new Pc();
    Pc pc3 = new Pc();
    Pc pc4 = new Pc();


    public Pc plugInPc1(Cable cable1, Cable cable4){
        cables.add(cable1);
        cables.add(cable4);
        cable1.setPcLeft(pc1);
        cable4.setPcRight(pc1);
        return pc1;
    }

}