package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "book")
public class Book implements Serializable {

    @Id
    private String id;
    private String name;
    private String author;
    private double price;

    public Book(String name,String author,double price){
        this.name=name;
        this.author=author;
        this.price=price;
    }
}
