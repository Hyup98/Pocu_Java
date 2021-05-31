package academy.pocu.comp2500.lab5;

import java.util.ArrayList;

public class Gladiator extends Barbarian {
    private int skillCount;
    private ArrayList<Move> skill;

    public Gladiator(String name, int maxHP, int str, int def) {
        super(name, maxHP, str, def);
        skillCount = 0;
        skill = new ArrayList<>();
    }

    public void rest() {
        addHp();
        for (int i = 0; i < skill.size(); i++) {
            skill.get(i).restSkill();
        }
    }

    public boolean addMove(Move move) {
        boolean check = true;
        if (skillCount == 4) {
            return false;
        }
        for (int i = 0; i < skill.size(); i++) {
            if (skill.get(i).getName().equals(move.getName())) {
                check = false;
            }
        }

        if (check) {
            Move tem = new Move(move.getName(), move.getSkillPower(), move.getMaxUseCount());
            skill.add(tem);
            skillCount++;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeMove(String name) {
        for (int i = 0; i < skill.size(); i++) {
            if (skill.get(i).getName().equals(name)) {
                skill.remove(i);
                return true;
            }
        }
        return false;
    }

    public void attack(String moveName, Barbarian enemy) {
        if (!isAlive()) {
            return;
        }
        if (enemy == this) {
            return;
        }
        int index = -1;
        for (int i = 0; i < skill.size(); i++) {
            if (skill.get(i).getName().equals(moveName)) {
                index = i;
            }
        }
        if (index == -1) {
            return;
        }
        if (skill.get(index).getUsingCount() == skill.get(index).getMaxUseCount()) {
            return;
        } else {
            skill.get(index).addUsingCount();
        }

        double tem = ((double) getStr() / enemy.getDef() * skill.get(index).getSkillPower()) / 2.0;
        int damage;
        if (tem < 1) {
            damage = 1;
        } else {
            damage = (int) tem;
        }

        if (damage > enemy.getHp()) {
            enemy.getDamage(enemy.getHp());
        } else {
            enemy.getDamage(damage);
        }



    }

}


