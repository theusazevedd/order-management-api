package com.azevedo.order_management_api.service;

import com.azevedo.order_management_api.converter.UserConverter;
import com.azevedo.order_management_api.dto.UserInDTO;
import com.azevedo.order_management_api.dto.UserOutDTO;
import com.azevedo.order_management_api.entities.UserEntity;
import com.azevedo.order_management_api.exceptions.ResourceNotFoundException;
import com.azevedo.order_management_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public List<UserOutDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::toOutDTO)
                .collect(Collectors.toList());
    }

    public UserOutDTO findById(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));
        return userConverter.toOutDTO(entity);
    }

    public UserOutDTO insert(UserInDTO dto) {
        UserEntity entity = userConverter.toEntity(dto);
        UserEntity saved = userRepository.save(entity);
        return userConverter.toOutDTO(saved);
    }

    public void delete(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));
        userRepository.deleteById(id);
    }

    public UserOutDTO update(Long id, UserInDTO dto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        UserEntity updated = userRepository.save(user);
        return userConverter.toOutDTO(updated);
    }

}
