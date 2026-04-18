package com.azevedo.order_management_api.controller;

import com.azevedo.order_management_api.entities.CategoryEntity;
import com.azevedo.order_management_api.entities.UserEntity;
import com.azevedo.order_management_api.service.CategoryService;
import com.azevedo.order_management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> findAll() {
        List<CategoryEntity> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> findById(@PathVariable Long id) {
        CategoryEntity categoryEntity = categoryService.findById(id);
        return ResponseEntity.ok().body(categoryEntity);
    }




}
