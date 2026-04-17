package com.azevedo.order_management_api.service;

import com.azevedo.order_management_api.entities.OrderEntity;
import com.azevedo.order_management_api.entities.UserEntity;
import com.azevedo.order_management_api.exceptions.ResourceNotFoundException;
import com.azevedo.order_management_api.repository.OrderRepository;
import com.azevedo.order_management_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    public OrderEntity findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));
    }


}
