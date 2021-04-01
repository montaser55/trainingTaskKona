package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.Optional;

public interface BookService {

    Book addBookService(Book book);

    Iterable<Book> getAllBooksService();

    Optional<Book> getBookbyIdService(String id);

    Optional<Book> getBookbyNameService(String name);

    Book updateBookbyIdService(String id, Book book);

    void deleteBookbyIdService(String id);

    void deleteBookbyTitleService(String name);
}
