package academy.pocu.comp2500.assignment3;

public class SmartMine extends Unit{
    private final int eyssight = 1;
    private int type = 1;// 1지상 / 2공중
    private int Aoe = 1;
    private int Ap = 15;
    private int threshold;

    public SmartMine(IntVector2D location, int threshold) {
        super(location, 1);
        this.threshold = threshold;
    }


}
