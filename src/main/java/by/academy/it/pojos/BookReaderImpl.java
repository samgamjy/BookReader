package by.academy.it.pojos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import by.academy.it.dao.IBookDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.pojos.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("bookReader")
public class BookReaderImpl implements BookReader {
    private List<Book> bookList;

    @Autowired
    private IBookDao bookDao;

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




    private List<Book> readFromFile (String fileName) throws DaoException {
        ClassLoader classLoader = BookReaderImpl.class.getClassLoader();
        InputStream input = classLoader.getResourceAsStream(fileName);
//        List<Book> booksFromFile = new ArrayList<Book>();


//        try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(input))) {

            try {
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(input));
//            BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
            String bookLine = inputStream.readLine();

            bookList.clear();
            while (bookLine != null) {
                Book book = extractBookFromLine(bookLine);
                bookLine = inputStream.readLine();
                bookList.add(book);

                bookDao.save(book);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return bookList;
    }



    @Override
    public List<Book> readBooks(String fileName) throws DaoException{
        return readFromFile(fileName);
    }
}
