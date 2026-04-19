package com.azevedo.order_management_api.controller;

import com.azevedo.order_management_api.dto.CategoryOutDTO;
import com.azevedo.order_management_api.service.CategoryService;
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
    public ResponseEntity<List<CategoryOutDTO>> findAll() {
        List<CategoryOutDTO> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryOutDTO> findById(@PathVariable Long id) {
        CategoryOutDTO categoryOutDTO = categoryService.findById(id);
        return ResponseEntity.ok().body(categoryOutDTO);
    }


}
