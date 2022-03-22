package com.example.fashionshopback.repository;

import com.example.fashionshopback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
