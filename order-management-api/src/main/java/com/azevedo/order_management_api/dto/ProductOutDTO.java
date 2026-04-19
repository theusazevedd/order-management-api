package com.azevedo.order_management_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOutDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Set<CategoryOutDTO> categories = new HashSet<>();

}

