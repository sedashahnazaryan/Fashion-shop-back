package com.example.fashionshopback.service.impl;

import com.example.fashionshopback.model.dto.request.Dto.OrderUpdateReqDto;
import com.example.fashionshopback.repository.OrderRepository;
import com.example.fashionshopback.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;


import javax.persistence.criteria.Order;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
 @Autowired
 private OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Order getById(long id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order update(long id, OrderUpdateReqDto order) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}

