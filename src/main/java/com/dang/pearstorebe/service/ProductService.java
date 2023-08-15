package com.dang.pearstorebe.service;

import com.dang.pearstorebe.dto.ProductDto;
import com.dang.pearstorebe.dto.ProductsByTypeDto;
import com.dang.pearstorebe.enums.ProductType;
import com.dang.pearstorebe.mapper.ProductMapper;
import com.dang.pearstorebe.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto findById(long id){
        return productMapper.toDto(productRepository.findById(id));
    }
    public ProductDto addNewProduct(ProductDto productDto){
            return productMapper.toDto(
                    productRepository.save(productMapper.toEntity(productDto))
            );
    }

    public ProductsByTypeDto getProductNames(String productTypeCode){
       return new ProductsByTypeDto(
             productMapper.toProduct(
                     productRepository.findByProductType(
                             ProductType.geTypeByCode(productTypeCode)
                     )
             )
       );
    }
}
