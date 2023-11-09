package com.dang.pearstorebe.orderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
public class GetAllOrderResponse {
    private List<Order> orders;

    @Builder
    @Data
    @AllArgsConstructor
    public static class Order{
        private String name;
        private long orderId;
        private int amount;
    }
}
