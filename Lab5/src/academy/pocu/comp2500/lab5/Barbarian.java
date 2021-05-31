package academy.pocu.comp2500.lab5;

public class Barbarian {
    private final String name;
    private final int maxHP;
    private int hp;
    private final int str;
    private final int def;

    public Barbarian(String name, int maxHP, int str, int def) {
        this.maxHP = maxHP;
        this.name = name;
        this.str = str;
        this.def = def;
        hp = maxHP;
    }

    public int getHp() {
        return hp;
    }

    public void attack(Barbarian enemy) {
        if (!isAlive()) {
            return;
        }
        if (enemy == this) {
            return;
        }
        double tem = 0;
        int damage;
        if (str <= enemy.def) {
            damage = 1;
        } else {
            tem = ((double) str - enemy.def) / 2;
            damage = (int) tem;
        }
        if (damage > enemy.hp) {
            enemy.hp = 0;
        } else {
            enemy.hp -= damage;
        }
    }

    public boolean isAlive() {
        return hp != 0;
    }

    public int getStr() {
        return str;
    }

    public int getDef() {
        return def;
    }

    public void getDamage(int i) {
        if (i == -1) {
            if (hp == maxHP) {
                return;
            }
            hp += 10;
        } else {
            hp -= i;
        }
    }
}
