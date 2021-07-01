package academy.pocu.comp2500.lab7;

import java.util.ArrayList;
import java.util.Objects;

public class ReadingList {
    private ArrayList<String> readedBooks = new ArrayList<>();
    private String listName;

    public ReadingList(String listName) {
        this.listName = listName;
    }

    public void add(Book book) {
        readedBooks.add(book.toString());
        return;
    }

    public boolean remove(Book book) {
        for (int i = 0; i < readedBooks.size(); i++) {
            if (readedBooks.get(i).equals(book.toString())) {
                readedBooks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean equals(ReadingList other) {
        if (other == this) {
            return true;
        }

        if (other == null || !(other instanceof ReadingList)) {
            return false;
        }
        if(!this.listName.equals(other.listName)) {
            return false;
        }



        boolean bIsSame = true;
        for (int i = 0; i < readedBooks.size(); i++) {
            if (!other.readedBooks.contains(readedBooks.get(i))) {
                bIsSame = false;
            }
        }
        return bIsSame;
    }

    public String toString() {
        String tem = "";
        for(int i = 0; i < readedBooks.size(); i++) {
            tem += String.format("%d. %s",i+1,this.readedBooks.get(i).toString());
            tem += "\n";
        }
        return tem;
    }

    public int hashCode() {
        return Objects.hash(readedBooks, listName) ^ (readedBooks.size());
    }
}
