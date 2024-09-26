package com.msb.bookstoreservlet;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public BookService() {
        addBook(new Book("The Great Gatsby"));
    }

    public void addBook(Book book) {
        books.add(book);
    }

}
