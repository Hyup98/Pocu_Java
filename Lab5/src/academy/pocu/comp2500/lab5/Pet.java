package academy.pocu.comp2500.lab5;

public class Pet {
    private final String name;
    private final int str;

    public Pet(String name, int str) {
        this.name = name;
        this.str = str;
    }

    public int getStr() {
        return str;
    }

    public boolean isSame(Pet other) {
        boolean answer = false;
        if (name.equals(other.name)) {
            answer = true;
        }
        if (str == other.str) {
            answer = true;
        }
        return answer;
    }

}
