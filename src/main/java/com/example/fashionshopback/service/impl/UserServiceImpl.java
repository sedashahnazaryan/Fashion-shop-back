package com.example.fashionshopback.service.impl;

import com.example.fashionshopback.model.User;
import com.example.fashionshopback.repository.UserRepository;
import com.example.fashionshopback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }




    @Override
    public User getById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "user with id:" + id + "not founded"));
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
