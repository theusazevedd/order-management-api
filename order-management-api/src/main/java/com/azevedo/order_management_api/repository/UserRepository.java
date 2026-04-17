package com.azevedo.order_management_api.repository;

import com.azevedo.order_management_api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
