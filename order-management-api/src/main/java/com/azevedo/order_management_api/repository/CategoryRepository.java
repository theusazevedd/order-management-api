package com.azevedo.order_management_api.repository;

import com.azevedo.order_management_api.entities.CategoryEntity;
import com.azevedo.order_management_api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {


}
