package com.azevedo.order_management_api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Transient
    @Setter(AccessLevel.NONE)
    private Set<ProductEntity> products = new HashSet<>();

    public CategoryEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
