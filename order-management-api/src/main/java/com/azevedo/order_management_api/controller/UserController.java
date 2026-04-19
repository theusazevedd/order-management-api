package com.azevedo.order_management_api.controller;

import com.azevedo.order_management_api.dto.UserInDTO;
import com.azevedo.order_management_api.dto.UserOutDTO;
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
    public ResponseEntity<List<UserOutDTO>> findAll() {
        List<UserOutDTO> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutDTO> findById(@PathVariable Long id) {
        UserOutDTO userOutDTO = userService.findById(id);
        return ResponseEntity.ok().body(userOutDTO);
    }

    @PostMapping
    public ResponseEntity<UserOutDTO> insert(@RequestBody UserInDTO obj) {
        UserOutDTO userOutDTO = userService.insert(obj);
        return ResponseEntity.ok().body(userOutDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserOutDTO> update(@PathVariable Long id, @RequestBody UserInDTO obj) {
        UserOutDTO userOutDTO = userService.update(id, obj);
        return ResponseEntity.ok().body(userOutDTO);
    }

}
