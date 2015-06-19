package by.academy.it.dao;

//import main.java.by.academy.it.pojos;
//import by.academy.it.dao.exceptions.DaoException;

import by.academy.it.pojos.Book;

public interface IBookDao<Book> extends Dao<Book> {
    Book getBookByItem(String itemName, String itemVal);
}
