package com.dang.pearstorebe.orderService.service;

import com.dang.pearstorebe.orderService.dto.GetAllOrderResponse;
import com.dang.pearstorebe.orderService.dto.OrderRequest;
import com.dang.pearstorebe.orderService.entity.Order;
import com.dang.pearstorebe.orderService.mapper.OrderMapper;
import com.dang.pearstorebe.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;

    public OrderRequest add(OrderRequest orderRequest) {
        Order order = repository.save(mapper.toEntity(orderRequest));
        return mapper.toDto(order);
    }

    public GetAllOrderResponse getAll(String accountId) {
        List<Order> orders = repository.findByAccountId(accountId);
        return new GetAllOrderResponse(mapper.toOrderResponseDto(orders));
    }
}
