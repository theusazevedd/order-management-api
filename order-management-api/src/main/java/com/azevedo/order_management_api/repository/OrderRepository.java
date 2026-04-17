package com.azevedo.order_management_api.repository;

import com.azevedo.order_management_api.entities.OrderEntity;
import com.azevedo.order_management_api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
