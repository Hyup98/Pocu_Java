package academy.pocu.comp2500.lab6;

public class Menu {

    protected int price;
    protected boolean isValid;

    protected Menu(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean isValid() {
        return isValid;
    }
}