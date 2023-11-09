package com.dang.pearstorebe.orderService.entity;

import com.dang.pearstorebe.orderService.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRODUCT_TYPE")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "PRICE")
    private BigDecimal price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Order order;
}
