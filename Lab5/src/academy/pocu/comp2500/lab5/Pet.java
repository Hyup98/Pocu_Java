package academy.pocu.comp2500.lab5;

public class Pet {
    private final String name;
    private Knight master;
    private final int str;
    private boolean isHaveMaster;

    public Pet(String name, int str) {
        this.name = name;
        this.str = str;
        isHaveMaster = false;
    }

    public void setMster(Knight mater) {
        isHaveMaster = true;
        this.master = mater;
    }
    public void removeMaster() {
        master = null;
        isHaveMaster = false;
    }

    public Knight getMaster() {
        return master;
    }

    public boolean isHaveMaster() {
        return isHaveMaster;
    }

    public int getSTR() {
        return str;
    }
}
