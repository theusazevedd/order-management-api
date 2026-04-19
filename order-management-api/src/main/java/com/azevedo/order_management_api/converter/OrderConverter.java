package com.azevedo.order_management_api.converter;

import com.azevedo.order_management_api.dto.OrderOutDTO;
import com.azevedo.order_management_api.entities.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private OrderItemConverter orderItemConverter;

    public OrderOutDTO toOutDTO(OrderEntity entity) {
        if (entity == null) {
            return null;
        }
        OrderOutDTO dto = new OrderOutDTO();
        dto.setId(entity.getId());
        dto.setMoment(entity.getMoment());
        dto.setOrderStatus(entity.getOrderStatus().toString());
        dto.setClient(userConverter.toOutDTO(entity.getClient()));
        dto.setTotal(entity.getTotal());

        if (entity.getItems() != null) {
            entity.getItems().forEach(orderItem ->
                dto.getItems().add(orderItemConverter.toOutDTO(orderItem))
            );
        }

        return dto;
    }

}

