package com.azevedo.order_management_api.controller;

import com.azevedo.order_management_api.entities.OrderEntity;
import com.azevedo.order_management_api.entities.UserEntity;
import com.azevedo.order_management_api.service.OrderService;
import com.azevedo.order_management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderEntity>> findAll() {
        List<OrderEntity> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> findById(@PathVariable Long id) {
        OrderEntity orderEntity = orderService.findById(id);
        return ResponseEntity.ok().body(orderEntity);
    }




}
