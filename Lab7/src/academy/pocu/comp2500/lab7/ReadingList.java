package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public class ReadingList {
    private ArrayList<Book> readedBooks = new ArrayList<>();
    private String listName;

    public ReadingList(String listName) {
        this.listName = listName;
    }

    public void add(Book book) {
        Book tem = book;
        readedBooks.add(tem);
        return;
    }

    public boolean remove(Book book) {
        for (int i = 0; i < readedBooks.size(); i++) {
            if (readedBooks.get(i).equals(book)) {
                readedBooks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other == null || !(other instanceof ReadingList)) {
            return false;
        }

        ReadingList tem = (ReadingList) other;

        if (!this.listName.equals(tem.listName)) {
            return false;
        }
        if (this.readedBooks.size() != tem.readedBooks.size()) {
            return false;
        }

        boolean bIsSame = true;
        for (int i = 0; i < readedBooks.size(); i++) {
            if (!readedBooks.get(i).equals(tem.readedBooks.get(i))) {
                bIsSame = false;
            }
        }
        return bIsSame;
    }

    public String toString() {
        String tem = "";
        for (int i = 0; i < readedBooks.size(); i++) {
            tem += String.format("%d. %s", i + 1, this.readedBooks.get(i).toString());
            tem += System.lineSeparator();
        }
        return tem;
    }

    public int hashCode() {
        int tem = listName.hashCode();
        tem += readedBooks.hashCode();
        return tem;
    }
}
