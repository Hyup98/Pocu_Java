package academy.pocu.comp2500.lab7;

public enum Genre {
    SCIENCEFICTION(1),
    ROMANCE(2),
    BIOGRAPHY(3),
    FANTASY(4),
    MYSTERY(5),
    SUSPENSE(6);

    private final int value;
    Genre(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }
}