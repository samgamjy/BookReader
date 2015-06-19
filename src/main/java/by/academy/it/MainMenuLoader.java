package by.academy.it;

//import by.academy.it.dao.BookDao;
import by.academy.it.dao.IBookDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.pojos.Book;
import by.academy.it.pojos.BookReader;
import static by.academy.it.constants.Constant.*;

import by.academy.it.pojos.BookReaderImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * Created by sam on 14.06.2015.
 */
public class MainMenuLoader {

    public ApplicationContext context = new ClassPathXmlApplicationContext("context-config.xml");
    public IBookDao bookDao = context.getBean("bookDao", IBookDao.class);

    private void printMenu(){
        System.out.println("Menu:");;
        System.out.println("0. Load books from file");
        System.out.println("1. Get book by ID");
        System.out.println("2. Get book by name");
        System.out.println("3. Get book by author");
        System.out.println("4. Get book by year");
        System.out.println("5. Exit");
    }

    public void menuLoader() {

        while(true){
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int menuItem = scanner.nextInt();
            switch (menuItem){
                case 0:
                    loadFromFile();
                    break;
                case 1:
                    getBookList();
                    break;
                case 2:
                    getBookByID();
                    break;
                case 3:
                    getBookByName();
                    break;
                case 4:
                    getBookByAuthor();
                    break;
                case 5:
                    getBookByYear();
                    break;
                case 6:
                    System.exit(0);
                    break;

            }

        }
//        ((ClassPathXmlApplicationContext)context).close();

    }

    private void loadFromFile(){
        BookReader reader = (BookReader)context.getBean("bookReader", BookReader.class);

        try {
            List<Book> books = reader.readBooks(FILE_NAME);
            for (Book book : books) {
                System.out.println(book);
            }
        }catch (DaoException e){
            e.printStackTrace();
        }


    }

    private void getBookList() {

    }

    private void getBookByID(){

    }

    private void getBookByName(){

    }

    private void getBookByYear() {

    }

    private void getBookByAuthor() {


    }

}
