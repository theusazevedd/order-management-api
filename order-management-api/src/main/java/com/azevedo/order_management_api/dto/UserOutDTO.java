package com.azevedo.order_management_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOutDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;

}

