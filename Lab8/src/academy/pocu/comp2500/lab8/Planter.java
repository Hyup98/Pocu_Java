package academy.pocu.comp2500.lab8;

public class Planter {
    private int tem;
    private int waterAmount;
    private Sprinkler sprinkler;
    private Drainer drainer;

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
        tem = 0;

    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void subWater() {
        tem -= 7;
    }

    public void addWater() {
        tem += 15;
    }

    public void tick() {
        if (drainer != null) {
            drainer.onTick();
        }

        if (sprinkler != null) {
            sprinkler.onTick();
        }
        tem -= 2;
        if (waterAmount + tem < 0) {
            waterAmount = 0;
        } else {
            waterAmount += tem;
        }
        tem = 0;

    }

    public void installSmartDevice(SmartDevice device) {
        if (device.getType() == 1) {
            sprinkler = (Sprinkler) device;
            sprinkler.setPlanter(this);
        } else {
            drainer = (Drainer) device;
            drainer.setPlanter(this);
        }
    }


}
