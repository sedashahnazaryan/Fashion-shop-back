package com.example.fashionshop.service;

import com.example.fashionshop.model.Order;
import com.example.fashionshop.model.commons.enums.OrderStatus;
import com.example.fashionshop.model.dto.requestDto.OrderUpdateReqDto;

import java.util.List;

public interface OrderService {

    Order create(Order order);

    List<Order> getAllById(String id);

    List<Order> getAll();

//    Order update(String id, OrderUpdateReqDto order);

    void delete(Long id);

    List<Order> getOrderByStatus(String userId, OrderStatus orderStatus);

    void changeStatus(Long orderId, OrderStatus orderStatus);
}

