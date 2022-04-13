package com.example.fashionshop.service;

import com.example.fashionshop.model.Order;
import com.example.fashionshop.model.commons.enums.OrderStatus;
import com.example.fashionshop.model.dto.requestDto.OrderUpdateReqDto;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderService {

    List<Order> getAll();

    Order getOrderById(long orderId);

    List<Order> getOrderByStatus(String userId, OrderStatus orderStatus);

    void delete(Long id);

    List<Order> getAllById(String id);

    Order create(Order order);

//    Order update(String id, OrderUpdateReqDto order);

    @Transactional
    void changeStatus(Long orderId, OrderStatus orderStatus);

}

