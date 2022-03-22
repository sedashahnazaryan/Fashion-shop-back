package com.example.fashionshopback.repository;

import com.example.fashionshopback.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
