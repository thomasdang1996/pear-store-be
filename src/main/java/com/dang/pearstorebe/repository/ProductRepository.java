package com.dang.pearstorebe.repository;

import com.dang.pearstorebe.entity.Product;
import com.dang.pearstorebe.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByProductType(ProductType productType);

    Product findById(long id);
}
