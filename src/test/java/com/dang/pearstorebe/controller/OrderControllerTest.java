package com.dang.pearstorebe.controller;

import com.dang.pearstorebe.dto.GetAllOrderResponse;
import com.dang.pearstorebe.dto.OrderRequest;
import com.dang.pearstorebe.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class OrderControllerTest {
    @Mock
    private OrderService orderService;
    @InjectMocks
    private OrderController orderController;

    @Test
    public void addProduct_success() {
        OrderRequest orderRequest = OrderRequest
                .builder().accountId("123")
                .productId(1L)
                .amount(5)
                .build();

        when(orderService.add(isA(OrderRequest.class)))
                .thenReturn(orderRequest);

        ResponseEntity<OrderRequest> response = orderController.addProduct(orderRequest);

        assertThat(response)
                .isEqualTo(ResponseEntity.ok(orderRequest));
    }

    @Test
    public void findAll_success() {
        String accountId = "accountId123";
        GetAllOrderResponse.Order order = GetAllOrderResponse.Order
                .builder()
                .name("phone1")
                .orderId(1L)
                .amount(1)
                .build();
        GetAllOrderResponse getAllOrderResponse = GetAllOrderResponse
                .builder()
                .orders(List.of(order))
                .build();

        when(orderService.getAll(isA(String.class)))
                .thenReturn(getAllOrderResponse);

        ResponseEntity<GetAllOrderResponse> response = orderController.findAll(accountId);
        assertThat(response)
                .isEqualTo(ResponseEntity.ok(getAllOrderResponse));
    }
}
