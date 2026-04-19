package com.azevedo.order_management_api.converter;

import com.azevedo.order_management_api.dto.OrderItemOutDTO;
import com.azevedo.order_management_api.entities.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemConverter {

    public OrderItemOutDTO toOutDTO(OrderItem entity) {
        if (entity == null) {
            return null;
        }
        OrderItemOutDTO dto = new OrderItemOutDTO();
        dto.setProductId(entity.getProductEntity().getId());
        dto.setProductName(entity.getProductEntity().getName());
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        dto.setSubTotal(entity.getSubTotal());
        return dto;
    }

}

