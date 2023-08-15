package com.dang.pearstorebe.mapper;

import com.dang.pearstorebe.dto.ProductDto;
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
public abstract class ProductMapper implements AbstractMapper<Product, ProductDto> {
    @Override
    @Mapping(target = "productType", expression = "java(com.dang.pearstorebe.enums.ProductType.geTypeByCode(dto.getProductTypeCode()))")
    @Mapping(target = "order", ignore = true)
    public abstract Product toEntity(ProductDto dto);


    @Override
    @Mapping(target = "productTypeCode", source = "productType.code")
    public abstract ProductDto toDto(Product entity);

    @Override
    public abstract List<Product> toEntity(List<ProductDto> dtos);

    @Override
    public abstract List<ProductDto> toDto(List<Product> entities);

    public abstract ProductsByTypeDto.Product toProduct(Product productNames);

    public abstract List<ProductsByTypeDto.Product> toProduct(List<Product> productNames);


}
