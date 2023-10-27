package com.dang.pearstorebe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNewProductRequest {
    private Long id;
    private String name;
    private String productTypeCode;
    private BigDecimal price;
}
