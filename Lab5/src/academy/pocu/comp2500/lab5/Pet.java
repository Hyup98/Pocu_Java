package academy.pocu.comp2500.lab5;

public class Pet {
    private final String name;
    private final int STR;
    private boolean isHaveMaster;

    public Pet(String name, int STR) {
        this.name = name;
        this.STR = STR;
        isHaveMaster = false;
    }

    public void setMster() {
        isHaveMaster = true;
    }

    public boolean isHaveMaster() {
        return isHaveMaster;
    }

    public int getSTR() {
        return STR;
    }
}
