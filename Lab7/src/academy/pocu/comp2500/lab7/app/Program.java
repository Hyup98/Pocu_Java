package academy.pocu.comp2500.lab7.app;

import academy.pocu.comp2500.lab7.*;

import java.util.HashSet;

public class Program {

    public static void main(String[] args) {
        {
            /*
             * COMP2500 202005 Lab7 테스트 케이스(seolbeen)
             */

            // Author test

            Author author1 = new Author("same", "author");
            Author author2 = new Author("same", "author");
            Author author3 = new Author("diff", "author");
            Author author4 = author1;

            //System.out.print(author1.equals(author2));
            //System.out.print(author1.equals(author4));
            HashSet<Author> tem = new HashSet<>();
            System.out.print(tem.add(author1)); // true
            System.out.print(tem.add(author2)); // false
            //System.out.print(author1.equals(author2));
            System.out.print(tem.add(author3)); // true
            System.out.print(tem.add(author4)) ;



            assert (author1.toString().equals("same author"));
            assert (author2.toString().equals("same author"));
            assert (author3.toString().equals("diff author"));

            assert (author1.equals(author2));
            assert (!author1.equals(author3));
            assert (author1.equals(author4));
            assert (author2.equals(author1));
            assert (!author1.equals(author3));
            assert (!author3.equals(author1));
            assert (!author2.equals(author3));
            assert (!author3.equals(author2));

            assert (author1.hashCode() == author2.hashCode());
            assert (author1.hashCode() != author3.hashCode());

            System.out.print(author1.hashCode() - author2.hashCode());
            System.out.print(author1.equals(author2));


            // Book test
            Book book1 = new Book("same book", author1, 2020, Genre.ROMANCE);
            Book book2 = new Book("same book", author1, 2020, Genre.ROMANCE);
            Book book3 = new Book("diff book", author3, 2018, Genre.MYSTERY);

            assert (book1.toString().equals("same book [same author]"));
            assert (book2.toString().equals("same book [same author]"));
            assert (book3.toString().equals("diff book [diff author]"));

            assert (book1.equals(book2));
            assert (book2.equals(book1));
            assert (!book1.equals(book3));
            assert (!book3.equals(book1));
            assert (!book2.equals(book3));
            assert (!book3.equals(book2));

            assert (book1.hashCode() == book2.hashCode());
            assert (book1.hashCode() != book3.hashCode());

            // Bookshelf test
            Bookshelf bookshelf1 = new Bookshelf(3);
            Bookshelf bookshelf2 = bookshelf1;
            Bookshelf bookshelf3 = new Bookshelf(3);

            assert (bookshelf1.equals(bookshelf2));
            assert (bookshelf2.equals(bookshelf1));
            assert (!bookshelf1.equals(bookshelf3));
            assert (!bookshelf3.equals(bookshelf1));
            assert (!bookshelf2.equals(bookshelf3));
            assert (!bookshelf3.equals(bookshelf2));

            assert (bookshelf1.hashCode() == bookshelf2.hashCode());
            assert (bookshelf1.hashCode() != bookshelf3.hashCode());

            // Bundle test
            Bundle bundle1 = new Bundle("same bundle");
            Bundle bundle2 = new Bundle("same bundle");
            Bundle bundle3 = new Bundle("diff bundle");

            bundle1.add(book1);
            bundle1.add(book2);
            bundle1.add(book3);

            bundle2.add(book1);
            bundle2.add(book2);
            bundle2.add(book3);

            bundle3.add(book1);
            bundle3.add(book2);
            bundle3.add(book3);

            assert (bundle1.equals(bundle2));
            assert (bundle2.equals(bundle1));
            assert (!bundle1.equals(bundle3));
            assert (!bundle3.equals(bundle1));
            assert (!bundle2.equals(bundle3));
            assert (!bundle3.equals(bundle2));

            assert (bundle1.hashCode() == bundle2.hashCode());
            assert (bundle1.hashCode() != bundle3.hashCode());

            // ReadingList test
            ReadingList readingList1 = new ReadingList("same list");
            ReadingList readingList2 = new ReadingList("same list");
            ReadingList readingList3 = new ReadingList("diff list");

            readingList1.add(book1);
            readingList1.add(book2);
            readingList1.add(book3);

            readingList2.add(book1);
            readingList2.add(book2);
            readingList2.add(book3);

            readingList3.add(book1);
            readingList3.add(book2);
            readingList3.add(book3);

            String format = String.format("%d. %s%s%d. %s%s%d. %s%s",
                    1, book1.toString(), System.lineSeparator(),
                    2, book2.toString(), System.lineSeparator(),
                    3, book3.toString(), System.lineSeparator());
            System.out.print(format);

            System.out.print(readingList1.toString());
            assert (readingList1.toString().equals(format));
            assert (readingList2.toString().equals(format));
            assert (readingList3.toString().equals(format));
            assert (readingList1.toString().equals(readingList3.toString()));

            assert (readingList1.equals(readingList2));
            assert (readingList2.equals(readingList1));
            assert (!readingList1.equals(readingList3));
            assert (!readingList3.equals(readingList1));
            assert (!readingList2.equals(readingList3));
            assert (!readingList3.equals(readingList2));

            assert (readingList1.hashCode() == readingList2.hashCode());
            assert (readingList1.hashCode() != readingList3.hashCode());
        }
    }
}