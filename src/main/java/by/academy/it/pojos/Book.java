package main.java.by.academy.it.pojos;

/**
 * Created by sam on 11.06.2015.
 */
public class Book {

    private String bookName;
    private String author;
    private String year;

    public Book(String bookName, String author, String year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
        if (year != null ? !year.equals(book.year) : book.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookName != null ? bookName.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
