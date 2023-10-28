package com.dang.pearstorebe.controller;

import com.dang.pearstorebe.dto.GetAllOrderResponse;
import com.dang.pearstorebe.dto.OrderRequest;
import com.dang.pearstorebe.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pear-store-be/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity<OrderRequest> addProduct(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.add(orderRequest));
    }
    @CrossOrigin
    @GetMapping("all")
    public ResponseEntity<GetAllOrderResponse> findAll(@RequestParam String accountId) {
        return ResponseEntity.ok(orderService.getAll(accountId));
    }

}
