package academy.pocu.comp2500.lab5;

public class Pet {
    private final String name;
    private Knight master;
    private final int STR;
    private boolean isHaveMaster;

    public Pet(String name, int STR) {
        this.name = name;
        this.STR = STR;
        isHaveMaster = false;
    }

    public void setMster(Knight mater) {
        isHaveMaster = true;
        this.master = mater;
    }
    public void removeMaster(){
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
        return STR;
    }
}
