package academy.pocu.comp2500.lab8;


public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {
    private int maxAmount;
    private boolean isOn;
    private Planter planter;

    public Drainer(int maxAmount) {
        super(2);
        this.maxAmount = maxAmount;
        this.isOn = false;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void drain(Planter planter) {
        planter.subWater();
    }

    public int getTicksSinceLastUpdate() {
        return getTictak() - getOnTime();
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void run() {
        if (getTictak() != 0) {
            if (maxAmount <= planter.getWaterAmount()) {
                if (isOn == false) {
                    setOnTime(getTictak());
                    drain(planter);
                    isOn = true;
                } else {
                    drain(planter);
                }

            } else {
                if (isOn == true) {
                    setOnTime(getTictak());
                    isOn = false;
                }

            }
        }
    }

    public void setPlanter(Planter planter) {
        this.planter = planter;
    }

    public void detect(final int waterLevel) {

    }

}
