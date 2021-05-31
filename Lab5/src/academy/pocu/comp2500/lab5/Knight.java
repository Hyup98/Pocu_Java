package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private boolean isHavePet;
    private Pet pet;

    public Knight(String name, int maxHP, int str, int def) {
        super(name, maxHP, str, def);
        isHavePet = false;
    }

    public void removePet() {
        if (pet != null) {
            pet = null;
        } else {
            return;
        }
    }


    public void setPet(Pet pet) {
        if (pet == null) {
            if (isHavePet) {
                this.pet.removeMaster();
            }
            isHavePet = false;
            this.pet = null;
        }
        if (!pet.isHaveMaster()) {
            if (!isHavePet) {
                this.pet = pet;
                pet.setMster(this);
                isHavePet = true;
            } else {
                return;
            }
        } else {
            pet.getMaster().isHavePet = false;
            pet.getMaster().removePet();
            pet.setMster(this);
            isHavePet = true;
            this.pet = pet;
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
            if (getStr() + pet.getSTR() - enemy.getDef() < 2) {
                damage = 1;
            } else {
                double tem = (double) (getStr() + pet.getSTR() - enemy.getDef()) / 2;
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
