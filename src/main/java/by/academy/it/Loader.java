package by.academy.it;

import main.java.by.academy.it.pojos.Book;

import java.io.IOException;
import java.util.List;

//import org.springframework.pojos.BeansException;
import main.java.by.academy.it.pojos.BookReaderImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static main.java.by.academy.it.constants.Constant.*;

/**
 * Hello world!
 *
 */
public class Loader
{
    public static void main( String[] args ) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context-config.xml");
        BookReaderImpl reader = (BookReaderImpl)context.getBean("bookReaderImpl");
        List<Book> books = reader.readBooks(FILE_NAME);
        for (Book book: books){
            System.out.println(book);
        }
        ((ClassPathXmlApplicationContext)context).close();

    }
}
