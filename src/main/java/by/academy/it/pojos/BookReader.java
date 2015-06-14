package main.java.by.academy.it.pojos;

import java.io.IOException;
import java.util.List;

public interface BookReader {
    List<Book> readBooks(String fileName) throws IOException;

}

