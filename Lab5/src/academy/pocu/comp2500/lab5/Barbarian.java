package academy.pocu.comp2500.lab5;

public class Barbarian {
    private final String name;
    private final int maxHP;
    private int HP;
    private final int STR;
    private final int DEF;

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
        if(!isAlive()){
            return;
        }
        if(enemy == this){
            return;
        }
        double tem = 0;
        int damage;
        if (STR <= enemy.DEF) {
            damage = 1;
        } else {
            tem = ((double) STR - enemy.DEF) / 2;
            damage = (int) tem;
        }
        if(damage > enemy.HP){
            enemy.HP = 0;
        }
        else {
            enemy.HP -= damage;
        }
    }

    public boolean isAlive() {
        return HP != 0;
    }

    public void addHp() {
        if(HP == maxHP){
            return;
        }
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
