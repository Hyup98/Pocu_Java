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

    public ArrayList<Book> getBooks() {
        return books;
    }


    public int getTotalPrice(PricePolicy policy) {
        return policy.getTotalPrice(books);
    }


}