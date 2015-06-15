package by.academy.it.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by sam on 13.06.2015.
 */
@Aspect
public class BookAspect {
    private static Logger logger = Logger.getLogger(BookAspect.class);

    @Before("execution(* pojos.BookReaderImpl.readBooks(String)) && args(fileName)")
    public void logBefore(String fileName) {
        logger.info("Start reading the file " + fileName);
    }

    @After("execution(* pojos.BookReaderImpl.readBooks(String)) && args(fileName)")
    public void logAfter(String fileName) {
        logger.info("The file has been successfully read "  + fileName);
    }
}
