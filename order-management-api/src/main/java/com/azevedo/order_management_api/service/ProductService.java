package com.azevedo.order_management_api.service;

import com.azevedo.order_management_api.converter.ProductConverter;
import com.azevedo.order_management_api.dto.ProductOutDTO;
import com.azevedo.order_management_api.entities.ProductEntity;
import com.azevedo.order_management_api.exceptions.ResourceNotFoundException;
import com.azevedo.order_management_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    public List<ProductOutDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productConverter::toOutDTO)
                .collect(Collectors.toList());
    }

    public ProductOutDTO findById(Long id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));
        return productConverter.toOutDTO(entity);
    }

}
