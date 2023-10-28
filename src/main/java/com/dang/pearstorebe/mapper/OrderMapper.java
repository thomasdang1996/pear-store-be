package com.dang.pearstorebe.mapper;

import com.dang.pearstorebe.dto.GetAllOrderResponse;
import com.dang.pearstorebe.dto.OrderRequest;
import com.dang.pearstorebe.entity.Order;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        builder = @Builder(disableBuilder = true)
)
public interface OrderMapper extends AbstractMapper<Order, OrderRequest> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product.id", source = "productId")
    Order toEntity(OrderRequest dto);

    @Mapping(target = "productId", source = "entity.product.id")
    OrderRequest toDto(Order entity);


    List<Order> toEntity(List<OrderRequest> dtos);

    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "orderId", source = "id")
    GetAllOrderResponse.Order toOrderDto(Order order);

    List<OrderRequest> toDto(List<Order> entities);
    List<GetAllOrderResponse.Order> toOrderResponseDto(List<Order> entities);
}

