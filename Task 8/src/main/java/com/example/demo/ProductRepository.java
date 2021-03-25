package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
    Iterable<Product> findByPriceGreaterThanEqual(float price);
    Iterable<Product> findByNameStartingWithAndPriceLessThan(String name,float price);
}
