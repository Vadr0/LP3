package Actividad03;

public class Motor {
    private int numMotor;
    private int revPorMin;
    public Motor(int numMotor, int revPorMin){
        this.numMotor = numMotor;
        this.revPorMin = revPorMin;
    }
    public int getNumMotor(){
        return numMotor;
    }
    public int getRevPornMin(){
        return revPorMin;
    }
    public void setNumMotor(int numMotor){
        this.numMotor = numMotor;
    }
    public void setRevPorMin(int revPorMin){
        this.revPorMin = revPorMin;
    }
    @Override
    public String toString(){
        return "Serie: "+ numMotor + "\n"+
                "Rev/Min: "+revPorMin;
    }
}