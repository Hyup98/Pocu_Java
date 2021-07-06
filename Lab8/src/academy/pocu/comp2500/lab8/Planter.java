package academy.pocu.comp2500.lab8;

public class Planter {
    private int waterAmount;
    private Sprinkler sprinkler;
    private Drainer drainer;

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;

    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void subWater() {
        if (waterAmount >= 7) {
            waterAmount -= 7;
        } else {
            waterAmount = 0;
        }
    }

    public void addWater() {
        waterAmount += 15;
    }

    public void tick() {
        if (drainer != null) {
            drainer.onTick();
        }
        if (sprinkler != null) {
            sprinkler.onTick();
        }
        if (waterAmount >= 2) {
            waterAmount -= 2;
        } else {
            waterAmount = 0;
        }
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
