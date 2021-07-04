package academy.pocu.comp2500.assignment3;

public class Unit {
    private IntVector2D unitVector2D;
    private int hp;

    public Unit(IntVector2D a, int hp) {
        unitVector2D = a;
        this.hp = hp;
    }

    public IntVector2D getPosition() {
        return unitVector2D;
    }

    public int getHp() {
        return hp;
    }

    public AttackIntent attack() {
        return null;
    };

    public void onAttacked(int damage) {

    };

    public void onSpawn() {

    };

    public char getSymbol() {
        return ' ';
    };
}