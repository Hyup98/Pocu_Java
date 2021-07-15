package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public class SkyIsTheLimit {
    private int price;

    public SkyIsTheLimit(int price) {
        this.price = price;
    }

    public int getTotalPrice(ArrayList<Book> books) {
        if (books.size() == 0) {
            return 0;
        }
        double first = 0;
        double second = 0;
        double total = 0;
        if (books.size() >= 5) {
            for (int i = 0; i < books.size(); i++) {
                total += books.get(i).getPrice();
                if (books.get(i).getPrice() > first) {
                    second = first;
                    first = books.get(i).getPrice();
                } else if (books.get(i).getPrice() > second && books.get(i).getPrice() < first) {
                    second = books.get(i).getPrice();
                }
            }
            if (total >= price) {
                total -= first * 0.5;
                total -= second * 0.5;
            }
            return (int) total;
        } else {
            int tem = 0;
            for (int i = 0; i < books.size(); i++) {
                tem += books.get(i).getPrice();
            }
            return tem;
        }
    }
}
