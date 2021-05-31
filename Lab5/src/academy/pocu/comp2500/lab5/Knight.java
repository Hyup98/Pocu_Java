package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private boolean isHavePet;
    private Pet pet;

    Knight(String name, int maxHP, int STR, int DEF) {
        super(name, maxHP, STR, DEF);
        isHavePet = false;
    }

    public void setPet(Pet pet) {
        if (!pet.isHaveMaster()) {
            if (!isHavePet) {
                this.pet = pet;
                pet.setMster();
                isHavePet = true;
            } else {
                return;
            }
        } else {
            return;
        }
    }

    public void attackTogeter(Barbarian enemy) {
        if (isHavePet) {
            int damage;
            if (getSTR() + pet.getSTR() - enemy.getDEF() <= 0) {
                damage = 2;
            } else {
                double tem = (double) (getSTR() + pet.getSTR() - enemy.getDEF()) / 2;
                damage = (int) tem;
            }

            enemy.getDamage(damage);
        } else {
            return;
        }
    }


}
