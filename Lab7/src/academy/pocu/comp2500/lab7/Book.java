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

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }


        if (other == null || !(other instanceof Book)) {
            return false;
        }

        Book tem = (Book) other;

        if (publishingYear != tem.publishingYear) {
            return false;
        }

        boolean bIsSame = true;

        if (!bookName.equals(tem.bookName)) {
            bIsSame = false;
        }
        if (!author.toString().equals(tem.author.toString())) {
            bIsSame = false;
        }
        if (publishingYear != tem.publishingYear) {
            bIsSame = false;
        }
        if (tem.genre != genre) {
            bIsSame = false;
        }

        return bIsSame;
    }

    public int hashCode() {
        int tem = author.hashCode() + bookName.hashCode() * 11 + publishingYear * 31;
        if (genre == Genre.BIOGRAPHY) {
            tem += 1;
        } else if (genre == Genre.FANTASY) {
            tem += 2;
        } else if (genre == Genre.MYSTERY) {
            tem += 3;
        } else if (genre == Genre.ROMANCE) {
            tem += 4;
        } else if (genre == Genre.SUSPENSE) {
            tem += 5;
        } else if (genre == Genre.SCIENCE_FICTION) {
            tem += 6;
        }
        return tem;
    }


}
