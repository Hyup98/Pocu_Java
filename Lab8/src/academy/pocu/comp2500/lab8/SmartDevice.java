package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    private int type;
    private int tictak;
    private int onTime;

    public SmartDevice(int type) {
        this.tictak = 0;
        this.type = type;
    }

    public abstract boolean isOn();

    public void onTick() {
        tictak++;
        isOn();
    }

    public int getTictak() {
        return tictak;
    }

    public int getOnTime() {
        return onTime;
    }

    public void setOnTime(int onTime) {
        this.onTime = onTime;
    }

    public int getType() {
        return type;
    }

    public abstract int getTicksSinceLastUpdate();
}
