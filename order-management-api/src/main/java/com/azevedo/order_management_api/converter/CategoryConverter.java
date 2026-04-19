package com.azevedo.order_management_api.converter;

import com.azevedo.order_management_api.dto.CategoryOutDTO;
import com.azevedo.order_management_api.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryOutDTO toOutDTO(CategoryEntity entity) {
        if (entity == null) {
            return null;
        }
        CategoryOutDTO dto = new CategoryOutDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

}

