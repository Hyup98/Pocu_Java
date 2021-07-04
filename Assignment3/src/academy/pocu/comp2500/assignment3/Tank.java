package academy.pocu.comp2500.assignment3;

public class Tank extends Unit{
    private final String identifier = "T";
    private final int eyesight = 3;
    private final int type = 3; // 1지상 / 2공중
    private final int Aoe = 0;
    private final int Ap = 6;
    private boolean mode; // true-기본보드  false-공성모드

    public Tank(IntVector2D location) {
        super(location,85);
        mode = true;
    }

    public void changetoSiegeMode() {
        mode = false;
    }

    public void changetodefaultMode() {
        mode = true;
    }
}
