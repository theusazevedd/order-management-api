package com.azevedo.order_management_api.entities.pk;

import com.azevedo.order_management_api.entities.OrderEntity;
import com.azevedo.order_management_api.entities.ProductEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class OrderItemPK {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderItemPK that)) return false;
        return Objects.equals(orderEntity, that.orderEntity) && Objects.equals(productEntity, that.productEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderEntity, productEntity);
    }
}
