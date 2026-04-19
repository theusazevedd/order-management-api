package com.azevedo.order_management_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemOutDTO {

    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Double subTotal;

}

