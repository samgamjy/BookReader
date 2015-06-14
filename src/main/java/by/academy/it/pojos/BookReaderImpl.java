package main.java.by.academy.it.pojos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by sam on 11.06.2015.
 */


@Service("bookReaderImpl")
public class BookReaderImpl implements BookReader {
    private List<Book> bookList;

    public BookReaderImpl() {
        this.bookList = new ArrayList<Book>();
    }

    private Book extractBookFromLine(String bookLine) {
        String[] lines = bookLine.split(",");
        String name = lines[0];
        String author = lines[1];
        String year = lines[2];

        return new Book(name, author, year);
    }




    private List<Book> readFromFile (String fileName) throws IOException {
        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
        String bookLine = inputStream.readLine();

        bookList.clear();
        while (bookLine != null) {
            Book book = extractBookFromLine(bookLine);
            bookLine = inputStream.readLine();
            bookList.add(book);
        }
        return bookList;
    }



    @Override
    public List<Book> readBooks(String fileName) throws IOException{
        return readFromFile(fileName);
    }
}
