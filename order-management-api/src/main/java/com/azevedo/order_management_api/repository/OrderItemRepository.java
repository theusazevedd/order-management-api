package com.azevedo.order_management_api.repository;

import com.azevedo.order_management_api.entities.OrderEntity;
import com.azevedo.order_management_api.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
