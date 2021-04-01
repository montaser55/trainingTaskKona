package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(path = "")
    public @ResponseBody Book addBook(@RequestBody Book book){
        return bookService.addBookService(book);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookService.getAllBooksService();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Book> getBookbyId(@PathVariable("id") String id){
        return bookService.getBookbyIdService(id);
    }

    @GetMapping(path="/title")
    public @ResponseBody
    Optional<Book> getBookbyName(@RequestParam(value = "name") String name){
        return bookService.getBookbyNameService(name);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody Book updateBookbyId(@PathVariable("id") String id,@RequestBody Book book){
        return bookService.updateBookbyIdService(id,book);
    }


    @DeleteMapping(path="/{id}")
    public @ResponseBody void deleteBookbyId(@PathVariable("id") String id){
        bookService.deleteBookbyIdService(id);
    }


    @DeleteMapping(path="/title")
    public @ResponseBody void deleteBookbyTitle(@RequestParam("name") String name){
        bookService.deleteBookbyTitleService(name);
    }
}
