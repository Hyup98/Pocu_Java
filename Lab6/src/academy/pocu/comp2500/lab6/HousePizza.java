package academy.pocu.comp2500.lab6;

public class HousePizza extends Pizza {

    public HousePizza() {
        super(20);

        this.toppings.add(Topping.BLACK_OLIVES);
        this.toppings.add(Topping.RED_ONIONS);
        this.toppings.add(Topping.GREEN_PEPPERS);
        this.toppings.add(Topping.MOZZARELLA_CHEESE);
    }

    public boolean addBacon() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.BACON);
        this.isValid = (++this.meatCount == MAX_MEAT_COUNT);
        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = this.toppings.remove(Topping.BACON);

        if (isRemoved) {
            this.isValid = (--this.meatCount == MAX_MEAT_COUNT);
        }

        return isRemoved;
    }

    public boolean addPeperoni() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.PEPERONI);
        this.isValid = (++this.meatCount == MAX_MEAT_COUNT);
        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = this.toppings.remove(Topping.PEPERONI);

        if (isRemoved) {
            this.isValid = (--this.meatCount == MAX_MEAT_COUNT);
        }

        return isRemoved;
    }

    public boolean addSausages() {
        if (isValid()) {
            return false;
        }

        this.toppings.add(Topping.SAUSAGES);
        this.isValid = (++this.meatCount == MAX_MEAT_COUNT);
        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = this.toppings.remove(Topping.SAUSAGES);

        if (isRemoved) {
            this.isValid = (--this.meatCount == MAX_MEAT_COUNT);
        }

        return isRemoved;
    }
}