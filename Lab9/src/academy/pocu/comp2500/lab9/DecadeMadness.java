package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DecadeMadness {
    private HashSet<Integer> years = new HashSet<Integer>();

    public DecadeMadness() {
    }

    public int getTotalPrice(ArrayList<Book> books) {
        double total = 0;
        for (int i = 0; i < books.size(); i++) {
            years.add(books.get(i).getPublishedYear() / 10);
        }
        double count = 0;
        double tem = 0;
        Iterator iter = years.iterator();
        while (iter.hasNext()) {
            count = 0;
            tem = 0;
            int temY = (int)iter.next();
            for (int i = 0; i < books.size(); i++) {
                if (temY == ((books.get(i).getPublishedYear() / 10))) {
                    count++;
                    tem += books.get(i).getPrice();
                }
            }
            if (count > 1) {
                tem *= 0.8;
            }
            total += tem;
        }
        return (int) total;
    }

}
