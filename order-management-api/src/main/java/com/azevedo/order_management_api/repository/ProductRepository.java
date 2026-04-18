package com.azevedo.order_management_api.repository;

import com.azevedo.order_management_api.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


}
