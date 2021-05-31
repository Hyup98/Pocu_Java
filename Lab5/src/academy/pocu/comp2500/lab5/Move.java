package academy.pocu.comp2500.lab5;

public class Move {
    private String name;
    private int usingCount;
    private int skillPower;
    private int maxUseCount;

    Move(String skill, int skillPower, int maxUseCount) {
        name = skill;
        this.maxUseCount = maxUseCount;
        this.skillPower = skillPower;
        usingCount = 0;
    }

    public int getMaxUseCount() {
        return maxUseCount;
    }

    public int getSkillPower() {
        return skillPower;
    }

    public String getName() {
        return name;
    }

    public int getUsingCount() {
        return usingCount;
    }

    public void addUsingCount() {
        this.usingCount++;
    }

    public void restSkill() {
        if (usingCount == 0) {
            return;
        }
        this.usingCount--;
    }
}


