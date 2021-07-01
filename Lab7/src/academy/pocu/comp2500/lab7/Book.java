package academy.pocu.comp2500.lab7;


public class Book {
    private String bookName;
    private Author author;
    private int publishingYear;
    private Genre genre;

    public Book(String bookName, Author author, int publishingYear, Genre genre) {
        this.bookName = bookName;
        this.author = author;
        this.publishingYear = publishingYear;
        this.genre = genre;
    }

    public String toString() {
        return String.format("%s [%s]", this.bookName, this.author.toString());
    }

    public boolean equals(Book other) {
        if (other == this) {
            return true;
        }
        if(publishingYear != other.publishingYear) {
            return false;
        }

        if (other == null || !(other instanceof Book)) {
            return false;
        }

        boolean bIsSame = true;

        if (!bookName.equals(other.bookName)) {
            bIsSame = false;
        }
        if (!author.toString().equals(other.author.toString())) {
            bIsSame = false;
        }
        if (publishingYear != other.publishingYear) {
            bIsSame = false;
        }
        if (other.genre != genre) {
            bIsSame = false;
        }

        return bIsSame;
    }

    public int hashCode() {
        int tem = this.author.hashCode() ^ (this.bookName.hashCode() << this.publishingYear);
        return tem;
    }


}
