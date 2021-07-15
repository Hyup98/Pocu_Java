package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public class PricePolicy {
    private Cart cart;
    protected PricePolicy(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }
}
