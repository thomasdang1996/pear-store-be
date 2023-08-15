package com.dang.pearstorebe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsByTypeDto {
    private List<Product> products;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Product{
        private long id;
        private String name;

    }
}
