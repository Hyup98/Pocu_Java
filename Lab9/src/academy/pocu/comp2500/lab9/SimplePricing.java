package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public class SimplePricing {
    public SimplePricing() {
    }

    public int getTotalPrice(ArrayList<Book> books) {
        int tem = 0;
        for (int i = 0; i < books.size(); i++) {
            tem += books.get(i).getPrice();
        }
        return tem;
    }
}