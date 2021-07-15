package academy.pocu.comp2500.lab9;

import java.util.ArrayList;

public final class Cart {
    private ArrayList<Book> books = new ArrayList<>();

    public Book getBookOrNull(int index) {
        if (this.books.size() <= index) {
            return null;
        }

        return this.books.get(index);
    }

    public int getBookCount() {
        return this.books.size();
    }

    public void addBooks(final Book[] book) {

        for (int i = 0; i < book.length; ++i) {
            this.books.add(book[i]);
        }
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public boolean remove(int index) {
        if (this.books.size() <= index) {
            return false;
        }

        this.books.remove(index);

        return true;
    }

    public int getTotalPrice(SkyIsTheLimit tem) {
        return tem.getTotalPrice(books);
    }

    public int getTotalPrice(BuyOneGetOneFree tem) {
        return tem.getTotalPrice(books);
    }

    public int getTotalPrice(DecadeMadness tem) {
        return tem.getTotalPrice(books);
    }

    public int getTotalPrice(SimplePricing tem) {
        return tem.getTotalPrice(books);
    }

    public int getTotalPrice() {
        int sum = 0;

        for (Book book : this.books) {
            sum += book.getPrice();
        }

        return sum;
    }

}