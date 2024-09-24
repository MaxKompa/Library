package com.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }


    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (!books.contains(book)) {
            books.add(book);
        }
    }


    public boolean removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        return books.remove(book);
    }


    public List<Book> getBooks() {
        return new ArrayList<>(books); // захист від змін
    }


    public int getBookCount() {
        return books.size();
    }
}

