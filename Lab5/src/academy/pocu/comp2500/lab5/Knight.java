package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private boolean isHavePet;
    private Pet pet;

    public Knight(String name, int maxHP, int str, int def) {
        super(name, maxHP, str, def);
        isHavePet = false;
    }

    public void setPet(Pet pet) {
        if (pet == null) {
            isHavePet = false;
            this.pet = null;
        } else {
            if (isHavePet) {
                if (this.pet.isSame(pet)) {
                    return;
                } else {
                    this.pet = pet;
                }
            } else {
                isHavePet = true;
                this.pet = pet;
            }
        }
    }

    public void attackTogether(Barbarian enemy) {
        if (!isAlive()) {
            return;
        }
        if (enemy == this) {
            return;
        }
        if (isHavePet) {
            int damage;
            if (getStr() + pet.getStr() - enemy.getDef() < 2) {
                damage = 1;
            } else {
                double tem = (double) (getStr() + pet.getStr() - enemy.getDef()) / 2;
                damage = (int) tem;
            }
            if (damage > enemy.getHp()) {
                enemy.getDamage(enemy.getHp());
            } else {
                enemy.getDamage(damage);
            }

        } else {
            return;
        }
    }


}
