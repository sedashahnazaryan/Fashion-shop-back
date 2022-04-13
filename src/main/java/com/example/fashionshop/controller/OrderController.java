package com.example.fashionshop.controller;

import com.example.fashionshop.model.Order;
import com.example.fashionshop.model.commons.enums.OrderStatus;
import com.example.fashionshop.model.dto.requestDto.OrderUpdateReqDto;
import com.example.fashionshop.model.dto.requestDto.ResponseDto;
import com.example.fashionshop.service.OrderService;
import com.example.fashionshop.validation.OrderValidator;
import com.example.fashionshop.validation.ProductValidator;
import com.example.fashionshop.validation.UserValidator;
import com.example.fashionshop.validation.ValidationConstants;
import com.example.fashionshop.validation.dto.OrderDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    /***
     *
     * @return all orders
     */
    @GetMapping("get-all")
    ResponseEntity<List<Order>> getAll(){
        return  ResponseEntity.ok(orderService.getAll());
    }

    /***
     *
     * @param userId is used to get all the orders made by  current user
     * @return return to front-end all  the orders by current user,if process is has been done authorized/UNAUTHORIZED
     */
    @GetMapping("/user-order")
    ResponseEntity<List<Order>> getOrdersByUserId(@RequestHeader String userId) {
        UserValidator.checkUserAuthorized(userId, HttpStatus.UNAUTHORIZED, "user is UNAUTHORIZED, plz SignUp at first");
        return ResponseEntity.ok(orderService.getAllById(userId));

    }

    /***
     *
     * @param userId userId is used to get all the orders made by  current user
     * @param orderStatus is used to get orders with this mentioned status
     * @return  return on array of orders that matched our provided userId and order status
     */
    @GetMapping("/order-status")
    ResponseEntity<List<Order>> getOrderByStatus(@RequestHeader String userId,
                                                 @RequestHeader("status") OrderStatus orderStatus) {
        UserValidator.checkUserAuthorized(userId, HttpStatus.UNAUTHORIZED, "user is UNAUTHORIZED, plz SignUp at first");

        return ResponseEntity.ok(orderService.getOrderByStatus(userId, orderStatus));
    }

    /***
     *
     * @param order is made from the provided information  by front-end which includes
     *              •product
     *              •user
     *              •additional order details
     * @param userId  property is used to determine if the user has authorisation to make changes in database
     * @return responseDto to inform front-end that process has been done successfully/ failed
     */
    @PostMapping
    ResponseEntity<ResponseDto> create(@RequestBody Order order,
                                       @RequestHeader String userId) {
        UserValidator.checkUserAuthorized(order.getUser().getId(), HttpStatus.UNAUTHORIZED, ValidationConstants.UNAUTHORIZED_ERROR);
        ProductValidator.validateCreateProduct(order.getProduct(), HttpStatus.BAD_REQUEST, ValidationConstants.ORDER_ERROR_PRODUCT);
        OrderValidator.validateOrder(order, HttpStatus.BAD_REQUEST, "validation for order failed, plz check order description");
        Order created = orderService.create(order);
        ResponseDto responseDto = new ResponseDto("Order created.");
        responseDto.addInfo("OrderId", String.valueOf(created.getId()));
        return ResponseEntity.ok(responseDto);
    }

    /***
     *
     * @param userId property is used to determine if the user has authorisation to make changes in database
     * @param orderId is to get the necessary order  which status will be changed
     * @param orderStatus is  the new status for the current order
     * @return responseDto to inform front-end that process has been done successfully/ failed
     */
    @PutMapping("/change-status/{orderId}/{status}")
    ResponseEntity<ResponseDto> changeStatus(@RequestHeader("userId") String userId,
                                             @PathVariable("orderId") Long orderId,
                                             @PathVariable("status") OrderStatus orderStatus) {
        UserValidator.checkUserAuthorized(userId, HttpStatus.UNAUTHORIZED, "user is UNAUTHORIZED, plz SignUp at first");
        OrderValidator.validateOrderChangeStatus(orderService.getOrderById(orderId),orderStatus, HttpStatus.BAD_REQUEST, "products in stock is not available or the count is not enough!");
        orderService.changeStatus(orderId, orderStatus);
        ResponseDto responseDto = new ResponseDto("OrderStatus changed.");
        responseDto.addInfo("OrderStatus", String.valueOf(orderId));
        return ResponseEntity.ok(responseDto);
    }

    /***
     *
     * @param id is used  to find the corresponding order that will be deleted
     * @param userId property is used to determine if the user has authorisation to make changes in database
     * @return responseDto to inform front-end that process has been done successfully/ failed
     *
     */
    @DeleteMapping("/{idOrder}")
    ResponseEntity<ResponseDto> delete(@PathVariable("idOrder") Long id,
                                       @RequestHeader String userId) {
        UserValidator.checkUserAuthorized(userId, HttpStatus.UNAUTHORIZED, "user is UNAUTHORIZED, plz SignUp at first");
        orderService.delete(id);
        ResponseDto responseDto = new ResponseDto("Order deleted.");
        responseDto.addInfo("OrderId", String.valueOf(id));
        return ResponseEntity.ok(responseDto);
    }
   }