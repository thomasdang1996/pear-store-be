package com.dang.pearstorebe.mapper;

import com.dang.pearstorebe.dto.GetAllOrderResponse;
import com.dang.pearstorebe.dto.OrderDto;
import com.dang.pearstorebe.entity.Order;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        builder = @Builder(disableBuilder = true)
)
public interface OrderMapper extends AbstractMapper<Order, OrderDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product.id", source = "productId")
    Order toEntity(OrderDto dto);

    @Mapping(target = "productId", source = "entity.product.id")
    OrderDto toDto(Order entity);


    List<Order> toEntity(List<OrderDto> dtos);

    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "orderId", source = "id")
    GetAllOrderResponse.Order toOrderDto(Order order);

    List<OrderDto> toDto(List<Order> entities);
    List<GetAllOrderResponse.Order> toOrderResponseDto(List<Order> entities);
}

