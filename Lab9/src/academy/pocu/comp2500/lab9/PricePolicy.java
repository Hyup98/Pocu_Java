package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

abstract public class PricePolicy {
    public PricePolicy() {
    }

    abstract public int getTotalPrice(ArrayList<Book> books);
}
