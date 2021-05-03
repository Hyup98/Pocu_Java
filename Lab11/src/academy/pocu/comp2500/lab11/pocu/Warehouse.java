package academy.pocu.comp2500.lab11.pocu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class Warehouse {
    private WarehouseType type;
    private ArrayList<Product> products;

    public Warehouse(final WarehouseType type) {
        if (type == null) {
            throw new IllegalArgumentException("type must not be null!");
        }

        HashSet<WarehouseType> warehouses = retrieveWarehousesMock();

        if (!warehouses.contains(type)) {
            throw new PermanentlyClosedException("Warehouse is not found or permanently closed");
        }

        this.type = type;
        this.products = retrieveProductsMock();
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> productsCopy = new ArrayList<>();

        for (Product product : this.products) {
            productsCopy.add(new Product(product.getId(), product.getName(), product.getPrice()));
        }

        return productsCopy;
    }

    public void removeProduct(final UUID id) {
        for (int i = 0; i < this.products.size(); ++i) {
            if (this.products.get(i).getId().equals(id)) {
                this.products.remove(i);

                if (isProductOutOfStockMock(i)) {
                    throw new ProductNotFoundException("Product not found!");
                }
            }
        }
    }

    private static HashSet<WarehouseType> retrieveWarehousesMock() {
        HashSet<WarehouseType> warehouses = new HashSet<>();

        warehouses.add(WarehouseType.APPLE);
        warehouses.add(WarehouseType.MICROSOFT);

        return warehouses;
    }

    private ArrayList<Product> retrieveProductsMock() {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(UUID.randomUUID(), "Lotion", 10));
        products.add(new Product(UUID.randomUUID(), "Pencil", 5));
        products.add(new Product(UUID.randomUUID(), "Notebook", 15));
        products.add(new Product(UUID.randomUUID(), "Eraser", 7));

        return products;
    }

    private static boolean isProductOutOfStockMock(int index) {
        return index == 3;
    }
}
