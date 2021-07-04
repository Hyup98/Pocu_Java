package academy.pocu.comp2500.assignment3;

public class Wraith extends Unit{
    private boolean isBarrier;
    private final String identifier = "W";
    private final int eyssight = 4;
    private int type = 2;// 1지상 / 2공중
    private int Aoe = 0;
    private int Ap = 6;

    public Wraith(IntVector2D location) {
        super(location,80);
        isBarrier = false;
    }
}
