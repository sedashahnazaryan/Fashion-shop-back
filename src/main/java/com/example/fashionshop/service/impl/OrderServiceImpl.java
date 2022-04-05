package com.example.fashionshop.service.impl;

import com.example.fashionshop.model.Order;
import com.example.fashionshop.model.commons.enums.OrderStatus;
import com.example.fashionshop.model.dto.requestDto.OrderUpdateReqDto;
import com.example.fashionshop.repository.OrderRepository;
import com.example.fashionshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }
    @Override
    @Transactional
    public void changeStatus(Long orderId, OrderStatus orderStatus) {
        Order fromDb = orderRepository.findById(orderId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Order with id:" + orderId + "  not found in database"));
        fromDb.setOrderStatus(orderStatus);
    }

    @Override
    public List<Order> getAllById(String id) {
        return orderRepository
                .getAllByUserId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Orders with user_id:" + id + "  not found in database")
                );
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }


    @Override
    public List<Order> getOrderByStatus(String userId, OrderStatus orderStatus) {
        return getAllById(userId).stream()
                .filter(item->item.getOrderStatus()==orderStatus)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}


