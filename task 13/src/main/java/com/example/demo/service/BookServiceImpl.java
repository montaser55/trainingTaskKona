package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    @CachePut(value = "books", key = "#book.id")
    public Book addBookService(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Iterable<Book> getAllBooksService() {
        return bookRepository.findAll();
    }

    @Override
    @Cacheable(value = "books", key = "#id")
    public Optional<Book> getBookbyIdService(String id) {
        return bookRepository.findById(id);
    }


    @Override
    public Optional<Book> getBookbyNameService(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    @CachePut(value = "books", key = "#id")
    public Book updateBookbyIdService(String id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @Override
    @CacheEvict(value = "books", key = "#id")
    public void deleteBookbyIdService(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteBookbyTitleService(String name) {
        bookRepository.deleteByName(name) ;
    }
}
