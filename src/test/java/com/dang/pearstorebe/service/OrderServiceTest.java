package com.dang.pearstorebe.service;

import com.dang.pearstorebe.dto.GetAllOrderResponse;
import com.dang.pearstorebe.dto.OrderRequest;
import com.dang.pearstorebe.entity.Order;
import com.dang.pearstorebe.mapper.OrderMapper;
import com.dang.pearstorebe.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class OrderServiceTest {
    @Mock
    private OrderRepository repository;
    @Spy
    private OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    @InjectMocks
    private OrderService orderService;

    @Test
    public void add_success() {
        OrderRequest orderRequest = OrderRequest
                .builder().accountId("123")
                .productId(1L)
                .amount(5)
                .build();
        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        orderService.add(orderRequest);
        verify(repository).save(orderCaptor.capture());
        assertThat(orderCaptor.getValue().getProduct().getId())
                .isEqualTo(1L);
    }

    @Test
    public void getAll_success() {
        Order order = new Order();
        order.setId(123L);
        order.setAmount(1);

        when(repository.findByAccountId(isA(String.class)))
                .thenReturn(List.of(order));
        GetAllOrderResponse response = orderService.getAll("accountId123");
        assertThat(response.getOrders())
                .isEqualTo(
                        List.of(GetAllOrderResponse.Order
                                .builder()
                                .orderId(123)
                                .amount(1)
                                .build()
                        ));
    }
}
