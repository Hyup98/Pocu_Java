package academy.pocu.comp2500.lab6;

import java.util.ArrayList;

public class VeggiePizza {
    private static final int PRICE = 17;
    private static final int MAX_CHEESE_COUNT = 2;

    private int price = PRICE;
    private ArrayList<Topping> toppings = new ArrayList<>();

    private int cheeseCount;

    public VeggiePizza() {
        this.toppings.add(Topping.BLACK_OLIVES);
        this.toppings.add(Topping.RED_ONIONS);
        this.toppings.add(Topping.GREEN_PEPPERS);
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.cheeseCount == MAX_CHEESE_COUNT;
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    public boolean addMozzarellaCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.MOZZARELLA_CHEESE);
        ++this.cheeseCount;
        return true;
    }

    public boolean removeMozzarellaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.MOZZARELLA_CHEESE);

        if (isRemoved) {
            --this.cheeseCount;
        }

        return isRemoved;
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.CHEDDAR_CHEESE);
        ++this.cheeseCount;
        return true;
    }

    public boolean removeCheddarCheese() {
        boolean isRemoved = this.toppings.remove(Topping.CHEDDAR_CHEESE);

        if (isRemoved) {
            --this.cheeseCount;
        }

        return isRemoved;
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.FETA_CHEESE);
        ++this.cheeseCount;
        return true;
    }

    public boolean removeFetaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.FETA_CHEESE);

        if (isRemoved) {
            --this.cheeseCount;
        }

        return isRemoved;
    }
}
