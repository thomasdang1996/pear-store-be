package com.dang.pearstorebe.mapper;

import com.dang.pearstorebe.dto.AddNewProductRequest;
import com.dang.pearstorebe.dto.ProductsByTypeDto;
import com.dang.pearstorebe.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        builder = @Builder(disableBuilder = true)
)
public interface ProductMapper extends AbstractMapper<Product, AddNewProductRequest> {
    @Override
    @Mapping(target = "productType", expression = "java(com.dang.pearstorebe.enums.ProductType.geTypeByCode(dto.getProductTypeCode()))")
    @Mapping(target = "order", ignore = true)
    Product toEntity(AddNewProductRequest dto);


    @Override
    @Mapping(target = "productTypeCode", source = "productType.code")
    AddNewProductRequest toDto(Product entity);

    @Override
    List<Product> toEntity(List<AddNewProductRequest> dtos);

    @Override
    List<AddNewProductRequest> toDto(List<Product> entities);

    ProductsByTypeDto.Product toProduct(Product productNames);

    List<ProductsByTypeDto.Product> toProduct(List<Product> productNames);
}
