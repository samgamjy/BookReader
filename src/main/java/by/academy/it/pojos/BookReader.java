package by.academy.it.pojos;

import by.academy.it.dao.exceptions.DaoException;
//import by.academy.it.pojos.Book;

//import java.io.IOException;
import java.util.List;

public interface BookReader {
    List<Book> readBooks(String fileName) throws DaoException;

}

