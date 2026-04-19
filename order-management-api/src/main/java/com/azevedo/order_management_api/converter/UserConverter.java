package com.azevedo.order_management_api.converter;

import com.azevedo.order_management_api.dto.UserInDTO;
import com.azevedo.order_management_api.dto.UserOutDTO;
import com.azevedo.order_management_api.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity toEntity(UserInDTO dto) {
        if (dto == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public UserEntity toEntity(UserOutDTO dto) {
        if (dto == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    public UserOutDTO toOutDTO(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        UserOutDTO dto = new UserOutDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        return dto;
    }

}

