package by.academy.it.dao;

//import by.academy.it.pojos.Book;
//import org.apache.log4j.Logger;
//import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.pojos.Book;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import java.util.List;

@Repository("bookDao")
public class BookDao extends BaseDao<Book> implements IBookDao<Book> {


//    private static Logger log = Logger.getLogger(UserDao.class);
//    private Transaction transaction = null;
//    private SessionFactory sessionFactory;

    @Autowired
    public BookDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Book getBookByItem(String itemName, String itemVal) {
        Book book;
        Session session = sessionFactory.openSession();// getCurrentSession();
        Criteria criteria = session.createCriteria(Book.class);
        book = (Book)criteria.add(Restrictions.eq(itemName, itemVal)).uniqueResult();
        return book;
    }
}
