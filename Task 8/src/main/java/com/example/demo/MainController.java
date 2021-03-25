package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class MainController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path="/product")
    public @ResponseBody Product addProduct(@RequestBody ProductWithoutId product){
        Product newProduct=new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        productRepository.save(newProduct);
        return newProduct;
    }   

    @GetMapping(path = "/products")
    public @ResponseBody Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping(path = "/price/{value}/{}")
    public @ResponseBody Iterable<Product> getProductsGreaterOrEqualThanPrice(@PathVariable("value") float value){
        return productRepository.findByPriceGreaterThanEqual(value);
    }

    @GetMapping(path = "/namestartandprice")
    public @ResponseBody Iterable<Product> getProductsGreaterOrEqualThanPrice(@RequestParam(value="name")String name, @RequestParam(value="price")float price){
        return productRepository.findByNameStartingWithAndPriceLessThan(name,price);
    }

    @GetMapping(path="/product/{id}")
    public @ResponseBody Optional<Product> getById(@PathVariable("id") Integer id){
        return productRepository.findById(id);
    }

    @PutMapping(path="/product/{id}")
    public @ResponseBody Product updateProduct(@PathVariable("id") Integer id,@RequestBody ProductWithoutId product){
        Product newProduct=new Product();
        newProduct.setId(id);
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        productRepository.save(newProduct);
        return newProduct;
    }

    @DeleteMapping(path="/product/{id}")
    public @ResponseBody void deleteById(@PathVariable("id") Integer id){
       productRepository.deleteById(id);
    }
}
