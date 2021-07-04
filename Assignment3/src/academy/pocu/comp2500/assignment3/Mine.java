package academy.pocu.comp2500.assignment3;

public class Mine extends Unit{
    private final String identifier = "N";
    private final int eyssight = 0;
    private int type = 1;// 1지상 / 2공중
    private int Aoe = 0;
    private int Ap = 10;
    private int countStep;
    private int threshold;

    public Mine(IntVector2D location, int threshold){
        super(location, 1);
        this.threshold = threshold;
    }

    public int getCountStep() {
        return countStep;
    }

    public void stepMine() {
        countStep++;
    }
}
