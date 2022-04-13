package com.example.fashionshop.service;

import com.example.fashionshop.model.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product getById(Long id);

    List<Product> getAll();

    Product update( Product product,long id);

    void delete(long id);

//    List<Product> getByAnyText(String anytext);
}
