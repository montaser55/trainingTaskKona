package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {
    public Optional<Book> findByName(String name);
    public void deleteByName(String name);
}
