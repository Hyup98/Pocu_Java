package academy.pocu.comp2500.lab5;

public class Pet {
    private String name;
    private int STR;
    private boolean isHaveMaster;

    Pet(String name, int STR) {
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
