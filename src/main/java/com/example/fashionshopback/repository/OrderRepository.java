package com.example.fashionshopback.repository;

import com.example.fashionshopback.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
