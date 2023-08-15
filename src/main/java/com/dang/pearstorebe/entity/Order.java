package com.dang.pearstorebe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountId;
    private int amount;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @JsonIgnore
    private Product product;
}
