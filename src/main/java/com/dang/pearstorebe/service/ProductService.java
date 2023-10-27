package com.dang.pearstorebe.service;

import com.dang.pearstorebe.dto.AddNewProductRequest;
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

    public AddNewProductRequest findById(long id){
        return productMapper.toDto(productRepository.findById(id));
    }
    public AddNewProductRequest addNewProduct(AddNewProductRequest addNewProductRequest){
            return productMapper.toDto(
                    productRepository.save(productMapper.toEntity(addNewProductRequest))
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
