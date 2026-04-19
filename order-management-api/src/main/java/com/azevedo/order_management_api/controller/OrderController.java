package com.azevedo.order_management_api.controller;

import com.azevedo.order_management_api.dto.OrderOutDTO;
import com.azevedo.order_management_api.service.OrderService;
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
    public ResponseEntity<List<OrderOutDTO>> findAll() {
        List<OrderOutDTO> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderOutDTO> findById(@PathVariable Long id) {
        OrderOutDTO orderOutDTO = orderService.findById(id);
        return ResponseEntity.ok().body(orderOutDTO);
    }


}
