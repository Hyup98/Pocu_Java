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

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other == null || !(other instanceof Bookshelf)) {
            return false;
        }

        Bookshelf tem = (Bookshelf) other;

        if (booksCount != tem.booksCount) {
            return false;
        }

        if (tem.books.size() == 0 && this.books.size() == 0) {
            int i = System.identityHashCode(this) - System.identityHashCode(tem);
            if (i == 0) {
                return true;
            } else {
                return false;
            }
        }

        boolean bIsSame = true;
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).equals(tem.books.get(i))) {
                bIsSame = false;
            }
        }
        return bIsSame;
    }

    public int hashCode() {
        int tem = booksCount;
        tem += books.hashCode();
        return tem;
    }
}
