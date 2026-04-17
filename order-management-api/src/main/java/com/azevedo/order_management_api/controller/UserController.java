package com.azevedo.order_management_api.controller;

import com.azevedo.order_management_api.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<UserEntity> findAll() {
        UserEntity user = new UserEntity(1L, "Maria", "maria@gmail.com", "11988445588", "12345");
        return ResponseEntity.ok().body(user);
    }

}
