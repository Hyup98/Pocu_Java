package academy.pocu.comp2500.assignment3;

public class Turret extends Unit{
    private final String identifier = "U";
    private final int eyssight = 2;
    private int type = 1;// 1지상 / 2공중
    private int Aoe = 0;
    private int Ap = 7;

    public Turret(IntVector2D location){
        super(location,99);
    }
}
