package com.azevedo.order_management_api.service;

import com.azevedo.order_management_api.converter.CategoryConverter;
import com.azevedo.order_management_api.dto.CategoryOutDTO;
import com.azevedo.order_management_api.entities.CategoryEntity;
import com.azevedo.order_management_api.exceptions.ResourceNotFoundException;
import com.azevedo.order_management_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    public List<CategoryOutDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryConverter::toOutDTO)
                .collect(Collectors.toList());
    }

    public CategoryOutDTO findById(Long id) {
        CategoryEntity entity = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));
        return categoryConverter.toOutDTO(entity);
    }

}
