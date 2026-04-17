package com.azevedo.order_management_api.controller;

import com.azevedo.order_management_api.entities.UserEntity;
import com.azevedo.order_management_api.repository.UserRepository;
import com.azevedo.order_management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id) {
        UserEntity userEntity = userService.findById(id);
        return ResponseEntity.ok().body(userEntity);
    }




}
