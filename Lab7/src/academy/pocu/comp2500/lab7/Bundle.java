package academy.pocu.comp2500.lab7;

import java.util.HashSet;
import java.util.Iterator;

public class Bundle {

    private HashSet<Book> books = new HashSet<>();
    private String bundleName;

    public Bundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public boolean add(Book book) {

        if (book == null) {
            return false;
        }
        Iterator<Book> iter = books.iterator();

        boolean bIspossible = true;
        while (iter.hasNext()) {
            if (iter.next().equals(book)) {
                bIspossible = false;
                break;
            }
        }
        while (iter.hasNext()) {
            if (iter.next().hashCode() == book.hashCode()) {
                bIspossible = false;
                break;
            }
        }
        if (bIspossible) {
            books.add(book);
            return bIspossible;
        } else {
            return bIspossible;
        }
    }

    public boolean remove(Book book) {
        Iterator<Book> iter = books.iterator();
        boolean bIspossible = false;
        while (iter.hasNext()) {
            if (iter.next().equals(book)) {
                bIspossible = true;
                books.remove(book);
                break;
            }
        }
        return bIspossible;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || !(other instanceof Bundle)) {
            return false;
        }

        Bundle tem = (Bundle) other;
        if (!this.bundleName.equals(tem.bundleName)) {
            return false;
        }

        Iterator<Book> iter = books.iterator();
        boolean bIspossible = true;
        while (iter.hasNext()) {
            if (!tem.books.contains(iter.next())) {
                bIspossible = false;
            }
        }
        return bIspossible;
    }

    public int hashCode() {
        return bundleName.hashCode() + books.hashCode();
    }
}
