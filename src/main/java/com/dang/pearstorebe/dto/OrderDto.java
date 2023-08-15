package com.dang.pearstorebe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OrderDto {
    private String accountId;
    private Long productId;
    private int amount;
}
