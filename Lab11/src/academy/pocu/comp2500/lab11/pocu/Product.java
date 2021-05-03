package academy.pocu.comp2500.lab11.pocu;

import java.util.UUID;

public final class Product {
    private final UUID id;
    private final String name;
    private final int price;

    public Product(final UUID id, final String name, final int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
