package com.example.fashionshop.repository;

import com.example.fashionshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fashionshop.model.commons.Image;
public interface ProductRepository extends JpaRepository<Product, Long> {
}
