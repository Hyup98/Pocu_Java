package academy.pocu.comp2500.lab6;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super(17);

        this.toppings.add(Topping.BLACK_OLIVES);
        this.toppings.add(Topping.RED_ONIONS);
        this.toppings.add(Topping.GREEN_PEPPERS);
    }

    public boolean addMozzarellaCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.MOZZARELLA_CHEESE);
        this.isValid = (++this.cheeseCount == MAX_CHEESE_COUNT);
        return true;
    }

    public boolean removeMozzarellaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.MOZZARELLA_CHEESE);

        if (isRemoved) {
            this.isValid = (--this.cheeseCount == MAX_CHEESE_COUNT);
        }

        return isRemoved;
    }

    public boolean addCheddarCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.CHEDDAR_CHEESE);
        this.isValid = (++this.cheeseCount == MAX_CHEESE_COUNT);
        return true;
    }

    public boolean removeCheddarCheese() {
        boolean isRemoved = this.toppings.remove(Topping.CHEDDAR_CHEESE);

        if (isRemoved) {
            this.isValid = (--this.cheeseCount == MAX_CHEESE_COUNT);
        }

        return isRemoved;
    }

    public boolean addFetaCheese() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.FETA_CHEESE);
        this.isValid = (++this.cheeseCount == MAX_CHEESE_COUNT);
        return true;
    }

    public boolean removeFetaCheese() {
        boolean isRemoved = this.toppings.remove(Topping.FETA_CHEESE);

        if (isRemoved) {
            this.isValid = (--this.cheeseCount == MAX_CHEESE_COUNT);
        }

        return isRemoved;
    }
}