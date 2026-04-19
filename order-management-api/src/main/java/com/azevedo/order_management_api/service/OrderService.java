package com.azevedo.order_management_api.service;

import com.azevedo.order_management_api.converter.OrderConverter;
import com.azevedo.order_management_api.dto.OrderOutDTO;
import com.azevedo.order_management_api.entities.OrderEntity;
import com.azevedo.order_management_api.exceptions.ResourceNotFoundException;
import com.azevedo.order_management_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    public List<OrderOutDTO> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderConverter::toOutDTO)
                .collect(Collectors.toList());
    }

    public OrderOutDTO findById(Long id) {
        OrderEntity entity = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));
        return orderConverter.toOutDTO(entity);
    }

}
