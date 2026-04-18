package com.azevedo.order_management_api.entities;

import com.azevedo.order_management_api.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem(OrderEntity orderEntity, ProductEntity productEntity, Integer quantity, Double price) {
        this.price = price;
        this.quantity = quantity;
        this.id.setOrderEntity(orderEntity);
        this.id.setProductEntity(productEntity);
    }

    @JsonIgnore
    public OrderEntity getOrderEntity() {
        return id.getOrderEntity();
    }

    public void setOrderEntity (OrderEntity orderEntity) {
        id.setOrderEntity(orderEntity);
    }

    public ProductEntity getProductEntity() {
        return id.getProductEntity();
    }

    public void setProductEntity(ProductEntity productEntity) {
        id.setProductEntity(productEntity);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderItem orderItem)) return false;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
