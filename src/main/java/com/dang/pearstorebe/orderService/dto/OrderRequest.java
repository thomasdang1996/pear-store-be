package com.dang.pearstorebe.orderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OrderRequest {
    private String accountId;
    private Long productId;
    private int amount;
}
