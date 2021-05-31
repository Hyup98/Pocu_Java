package academy.pocu.comp2500.lab5;

public class Barbarian {
    private String name;
    private int maxHP;
    private int HP;
    private int STR;
    private int DEF;

    public Barbarian(String name, int maxHP, int STR, int DEF) {
        this.maxHP = maxHP;
        this.name = name;
        this.STR = STR;
        this.DEF = DEF;
        HP = maxHP;
    }

    public int getHp() {
        return HP;
    }

    public void attack(Barbarian enemy) {
        double tem = 0;
        int damage;
        if (STR <= enemy.DEF) {
            damage = 1;
        } else {
            tem = ((double) STR - enemy.DEF) / 2;
            damage = (int) tem;
        }
        enemy.HP -= damage;
    }

    public boolean isAlive() {
        if (HP <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void addHp() {
        HP += 10;
    }

    public int getSTR() {
        return STR;
    }

    public int getDEF() {
        return DEF;
    }

    public void getDamage(int i) {
        HP -= i;
    }
}
