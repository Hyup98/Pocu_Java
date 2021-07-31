package academy.pocu.comp2500.lab11;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private int pirice;

    public Product(UUID id, String name, int price) {
        this.id = id;
        this.pirice = price;
        this.name = name;
    }

    public int getPirice() {
        return pirice;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
