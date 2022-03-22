package com.example.fashionshopback.service;

import com.example.fashionshopback.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getById(String id);

    List<User> getAll();

    void  delete (String id);
}
