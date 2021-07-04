package academy.pocu.comp2500.assignment3;

public class Marine extends Unit{
    private final String identifier = "M";
    private final int eyesight = 2;
    private final int type = 1;//1지상 / 2공중
    private final int Aoe = 0;
    private final int Ap = 6;

    public Marine(IntVector2D location) {
        super(location,35);
    }

}
