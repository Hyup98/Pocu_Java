package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public class Bookshelf {
    private int booksCount;
    private ArrayList<Book> books = new ArrayList<>();

    public Bookshelf(int booksCount) {
        this.booksCount = booksCount;
    }

    public boolean add(Book book) {
        if (booksCount == books.size()) {
            return false;
        } else {
            Book tem = book;
            books.add(tem);
            return true;
        }
    }

    public boolean remove(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (book.equals(books.get(i))) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean equals(Bookshelf other) {
        if (other == this) {
            return true;
        }
        if (booksCount != other.booksCount) {
            return false;
        }

        if (other == null || !(other instanceof Bookshelf)) {
            return false;
        }
        if (other.books.size() == 0) {
            return false;
        }

        boolean bIsSame = true;
        for (int i = 0; i < books.size(); i++) {
            if (!books.contains(other.books.get(i))) {
                bIsSame = false;
            }
        }
        return bIsSame;
    }

    public int hashCode() {

        return System.identityHashCode(this)+ booksCount * 31;
    }
}
