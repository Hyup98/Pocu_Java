package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {
    private boolean isHavePet;
    private Pet pet;

    public Knight(String name, int maxHP, int STR, int DEF) {
        super(name, maxHP, STR, DEF);
        isHavePet = false;
    }

    public void removePet(){
        if(pet != null){
            pet = null;
        }
        else {
            return;
        }
    }


    public void setPet(Pet pet) {
        if (!pet.isHaveMaster()) {
            if (!isHavePet) {
                this.pet = pet;
                pet.setMster(this);
                isHavePet = true;
            } else {
                return;
            }
        }
        else {
            if(isHavePet){
                pet.removeMaster();
            }
            pet.getMaster().isHavePet = false;
            pet.getMaster().removePet();
            pet.setMster(this);
            isHavePet = true;
            this.pet = pet;
        }
    }

    public void attackTogether(Barbarian enemy) {
        if(!isAlive()) {
            return;
        }
        if(enemy == this){
            return;
        }
        if (isHavePet) {
            int damage;
            if (getSTR() + pet.getSTR() - enemy.getDEF() < 2) {
                damage = 1;
            } else {
                double tem = (double) (getSTR() + pet.getSTR() - enemy.getDEF()) / 2;
                damage = (int) tem;
            }
            if(damage > enemy.getHp()){
                enemy.getDamage(enemy.getHp());
            }
            else {
                enemy.getDamage(damage);
            }

        }
        else {
            return;
        }
    }


}
