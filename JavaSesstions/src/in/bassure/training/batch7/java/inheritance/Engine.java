package in.bassure.training.batch7.java.inheritance;

public class Engine implements Cloneable {

    public String fuelType;
    public String torque;
    public int power;
    private CrankShaft crankShaft;

    {
        crankShaft = new CrankShaft("Honda", 19500);
    }

    public Engine(String fuelType, String torque, int power) {
        this.fuelType = fuelType;
        this.power = power;
        this.torque = torque;
    }

    public CrankShaft getCrankShaft() {
        return crankShaft;
    }

    public void setCrankShaft(CrankShaft crankShaft) {
        this.crankShaft = crankShaft;
    }

    @Override
    public String toString() {
        return "Engine[FuelType: " + fuelType + ", Torque:  " + torque
                + ", Power: " + power
                + ", CrankShaft: " + crankShaft + "]";
    }

    @Override
    protected Engine clone() throws CloneNotSupportedException {
        Engine copy =  (Engine) super.clone();
        copy.crankShaft = this.crankShaft.clone();
        return copy;
    }
}
