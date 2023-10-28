package com.dang.pearstorebe.service;

import com.dang.pearstorebe.dto.GetAllOrderResponse;
import com.dang.pearstorebe.dto.OrderRequest;
import com.dang.pearstorebe.entity.Order;
import com.dang.pearstorebe.mapper.OrderMapper;
import com.dang.pearstorebe.repository.OrderRepository;
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
