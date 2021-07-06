package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int tem;
    private int waterAmount;
    private ArrayList<Sprinkler> sprinklers = new ArrayList<>();
    private ArrayList<Drainer> drainers = new ArrayList<>();
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

        for (int i = 0; i < drainers.size(); i++) {
            if (drainers.get(i) != null) {
                drainers.get(i).onTick();
            }
        }

        for (int i = 0; i < sprinklers.size(); i++) {
            if (sprinklers.get(i) != null) {
                sprinklers.get(i).onTick();
            }
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
            sprinklers.add((Sprinkler) device);
            Sprinkler tem = (Sprinkler) device;
            tem.setPlanter(this);
        } else {
            drainers.add((Drainer) device);
            Drainer tem = (Drainer) device;
            tem.setPlanter(this);
        }
    }


}
