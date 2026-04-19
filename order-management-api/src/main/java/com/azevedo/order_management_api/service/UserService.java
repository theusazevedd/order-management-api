package com.azevedo.order_management_api.service;

import com.azevedo.order_management_api.entities.UserEntity;
import com.azevedo.order_management_api.exceptions.ResourceNotFoundException;
import com.azevedo.order_management_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));
    }

    public UserEntity insert(UserEntity obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserEntity update(Long id, UserEntity obj) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));

        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());

        return userRepository.save(user);
    }

}
