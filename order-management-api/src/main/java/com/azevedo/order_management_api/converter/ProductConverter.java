package com.azevedo.order_management_api.converter;

import com.azevedo.order_management_api.dto.ProductOutDTO;
import com.azevedo.order_management_api.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    @Autowired
    private CategoryConverter categoryConverter;

    public ProductOutDTO toOutDTO(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        ProductOutDTO dto = new ProductOutDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setImgUrl(entity.getImgUrl());

        if (entity.getCategories() != null) {
            entity.getCategories().forEach(categoryEntity ->
                dto.getCategories().add(categoryConverter.toOutDTO(categoryEntity))
            );
        }

        return dto;
    }

}

