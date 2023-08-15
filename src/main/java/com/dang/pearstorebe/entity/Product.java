package com.dang.pearstorebe.entity;

import com.dang.pearstorebe.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Order order;
}
