package com.azevedo.order_management_api.controller;

import com.azevedo.order_management_api.entities.UserEntity;
import com.azevedo.order_management_api.repository.UserRepository;
import com.azevedo.order_management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<UserEntity> insert(@RequestBody UserEntity obj) {
        UserEntity userEntity = userService.insert(obj);
        return ResponseEntity.ok().body(userEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable Long id, @RequestBody UserEntity obj) {
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
