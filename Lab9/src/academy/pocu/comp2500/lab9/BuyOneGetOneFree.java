package academy.pocu.comp2500.lab9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

public class BuyOneGetOneFree {
    private HashSet<UUID> skuNumber = new HashSet<>();

    public BuyOneGetOneFree(HashSet<UUID> sku) {
        skuNumber = sku;
    }

    public int getTotalPrice(ArrayList<Book> books) {
        //1+1 정책에 의한 가격 책정
        if (books.size() == 0) {
            return 0;
        }
        int count;
        int discount = 0;
        int tem = 0;
        int checkprice = 0;
        Iterator iter = skuNumber.iterator();
        while (iter.hasNext()) {//값이 있으면 true 없으면 false
            count = 0;
            UUID temId = (UUID) iter.next();
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getSku().equals(temId)) {
                    checkprice = books.get(i).getPrice();
                    break;
                }
            }
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getSku().equals(temId)) {
                    count++;
                }
            }
            if (count >= 2) {
                discount += (count / 2) * checkprice;
            }
        }
        for (int i = 0; i < books.size(); i++) {
            tem += books.get(i).getPrice();
        }
        return tem - discount;
    }


}

